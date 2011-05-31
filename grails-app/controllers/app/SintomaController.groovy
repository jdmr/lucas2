package app

import grails.converters.JSON

class SintomaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [sintomas: Sintoma.list(params), totalDeSintomas: Sintoma.count()]
    }

    def nuevo = {
        def sintoma = new Sintoma()
        sintoma.properties = params
        return [sintoma: sintoma]
    }

    def crea = {
        def sintoma = new Sintoma(params)
        if (sintoma.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), sintoma.id])
            redirect(action: "ver", id: sintoma.id)
        }
        else {
            log.debug("Hubo errores al intentar crear el sintoma ${sintoma.errors}")
            render(view: "nuevo", model: [sintoma: sintoma])
        }
    }

    def ver = {
        def sintoma = Sintoma.get(params.id)
        if (!sintoma) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), params.id])
            redirect(action: "lista")
        }
        else {
            [sintoma: sintoma]
        }
    }

    def edita = {
        def sintoma = Sintoma.get(params.id)
        if (!sintoma) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), params.id])
            redirect(action: "lista")
        }
        else {
            return [sintoma: sintoma]
        }
    }

    def actualiza = {
        def sintoma = Sintoma.get(params.id)
        if (sintoma) {
            if (params.version) {
                def version = params.version.toLong()
                if (sintoma.version > version) {

                   sintoma.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'sintoma.label', default: 'Sintoma')] as Object[], "Another user has updated this Paciente while you were editing")
                    render(view: "edita", model: [sintoma: sintoma])
                    return
                }
            }
            sintoma.properties = params
            if (!sintoma.hasErrors() && sintoma.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), sintoma.id])
                redirect(action: "ver", id: sintoma.id)
            }
            else {
                render(view: "edita", model: [sintoma: sintoma])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def sintoma = Sintoma.get(params.id)
        if (sintoma) {
            try {
                sintoma.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sintoma.label', default: 'Sintoma'), params.id])
            redirect(action: "lista")
        }
    }
}
