    package app

import grails.converters.JSON

class ExamenFisicoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [examenFisicos: ExamenFisico.list(params), totalDeExamenFisicos: ExamenFisico.count()]
    }

    def nuevo = {
        def examenFisico = new ExamenFisico()
        examenFisico.properties = params
        return [examenFisico: examenFisico]
    }

    def crea = {
        def examenFisico = new ExamenFisico(params)
        if (examenFisico.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), examenFisico.id])
            redirect(action: "ver", id: examenFisico.id)
        }
        else {
            log.debug("Hubo errores al intentar creare el examen fisico ${examenFisico.errors}")
            render(view: "nuevo", model: [examenFisico: examenFisico])
        }
    }

    def ver = {
        def examenFisico = ExamenFisico.get(params.id)
        if (!examenFisico) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), params.id])
            redirect(action: "lista")
        }
        else {
            [examenFisico: examenFisico]
        }
    }

    def edita = {
        def examenFisico = ExamenFisico.get(params.id)
        if (!examenFisico) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), params.id])
            redirect(action: "lista")
        }
        else {
            return [examenFisico: examenFisico]
        }
    }

    def actualiza = {
        def examenFisico = ExamenFisico.get(params.id)
        if (examenFisico) {
            if (params.version) {
                def version = params.version.toLong()
                if (examenFisico.version > version) {

                    examenFisico.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'examenFisico.label', default: 'Examen Fisico')] as Object[], "Another user has updated this ExamenFisico while you were editing")
                    render(view: "edita", model: [examenFisico: examenFisico])
                    return
                }
            }
            examenFisico.properties = params
            if (!examenFisico.hasErrors() && examenFisico.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), examenFisico.id])
                redirect(action: "ver", id: examenFisico.id)
            }
            else {
                render(view: "edita", model: [examenFisico: examenFisico])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def examenFisico = ExamenFisico.get(params.id)
        if (examenFisico) {
            try {
                examenFisico.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenFisico.label', default: 'Examen Fisico'), params.id])
            redirect(action: "lista")
        }
    }
}
