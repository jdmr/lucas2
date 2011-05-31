package app

import grails.converters.JSON

class TratamientoController {
    
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [tratamientos: Tratamiento.list(params), totalDeTratamientos: Tratamiento.count()]
    }

    def nuevo = {
        def tratamiento = new Tratamiento()
        tratamiento.properties = params
        return [tratamiento: tratamiento]
    }

    def crea = {
        def tratamiento = new Tratamiento(params)
        if (tratamiento.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), tratamiento.id])
            redirect(action: "ver", id: tratamiento.id)
        }
        else {
            log.debug("Hubo errores al intentar crear al diagnostico ${tratamiento.errors}")
            render(view: "nuevo", model: [tratamiento: tratamiento])
        }
    }

    def ver = {
        def tratamiento = Tratamiento.get(params.id)
        if (!tratamiento) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), params.id])
            redirect(action: "lista")
        }
        else {
            [tratamiento: tratamiento]
        }
    }

    def edita = {
        def tratamiento = Tratamiento.get(params.id)
        if (!tratamiento) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), params.id])
            redirect(action: "lista")
        }
        else {
            return [tratamiento: tratamiento]
        }
    }

    def actualiza = {
        def tratamiento = Tratamiento.get(params.id)
        if (tratamiento) {
            if (params.version) {
                def version = params.version.toLong()
                if (tratamiento.version > version) {

                    tratamiento.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'tratamiento.label', default: 'Tratamiento')] as Object[], "Another user has updated this diagnostic while you were editing")
                    render(view: "edita", model: [tratamiento: tratamiento])
                    return
                }
            }
            tratamiento.properties = params
            if (!tratamiento.hasErrors() && tratamiento.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), tratamiento.id])
                redirect(action: "ver", id: tratamiento.id)
            }
            else {
                render(view: "edita", model: [tratamiento: tratamiento])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def tratamiento = Tratamiento.get(params.id)
        if (tratamiento) {
            try {
                tratamiento.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tratamiento.label', default: 'Tratamiento'), params.id])
            redirect(action: "lista")
        }
    }
}
