package app

import grails.converters.JSON

class DiagnosticoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [diagnosticos: Diagnostico.list(params), totalDeDiagnosticos: Diagnostico.count()]
    }

    def nuevo = {
        def diagnostico = new Diagnostico()
        diagnostico.properties = params
        return [diagnostico: diagnostico]
    }

    def crea = {
        def diagnostico = new Diagnostico(params)
        if (diagnostico.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), diagnostico.id])
            redirect(action: "ver", id: diagnostico.id)
        }
        else {
            log.debug("Hubo errores al intentar crear al diagnostico ${diagnostico.errors}")
            render(view: "nuevo", model: [diagnostico: diagnostico])
        }
    }

    def ver = {
        def diagnostico = Diagnostico.get(params.id)
        if (!diagnostico) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), params.id])
            redirect(action: "lista")
        }
        else {
            [diagnostico: diagnostico]
        }
    }

    def edita = {
        def diagnostico = Diagnostico.get(params.id)
        if (!diagnostico) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), params.id])
            redirect(action: "lista")
        }
        else {
            return [diagnostico: diagnostico]
        }
    }

    def actualiza = {
        def diagnostico = Diagnostico.get(params.id)
        if (diagnostico) {
            if (params.version) {
                def version = params.version.toLong()
                if (diagnostico.version > version) {

                    diagnostico.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'diagnostico.label', default: 'Diagnóstico')] as Object[], "Another user has updated this diagnostic while you were editing")
                    render(view: "edita", model: [diagnostico: diagnostico])
                    return
                }
            }
            diagnostico.properties = params
            if (!diagnostico.hasErrors() && diagnostico.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), diagnostico.id])
                redirect(action: "ver", id: diagnostico.id)
            }
            else {
                render(view: "edita", model: [diagnostico: diagnostico])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def diagnostico = Diagnostico.get(params.id)
        if (diagnostico) {
            try {
                diagnostico.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'diagnostico.label', default: 'Diagnóstico'), params.id])
            redirect(action: "lista")
        }
    }
}
