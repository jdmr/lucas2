package app

import grails.converters.JSON

class PacienteController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pacientes: Paciente.list(params), totalDePacientes: Paciente.count()]
    }

    def nuevo = {
        def paciente = new Paciente()
        paciente.properties = params
        return [paciente: paciente]
    }

    def crea = {
        def paciente = new Paciente(params)
        if (paciente.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'paciente.label', default: 'Paciente'), paciente.id])
            redirect(action: "ver", id: paciente.id)
        }
        else {
            log.debug("Hubo errores al intentar crear el paciente ${paciente.errors}")
            render(view: "nuevo", model: [paciente: paciente])
        }
    }

    def ver = {
        def paciente = Paciente.get(params.id)
        if (!paciente) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'paciente.label', default: 'Paciente'), params.id])
            redirect(action: "lista")
        }
        else {
            [paciente: paciente]
        }
    }

    def edita = {
        def paciente = Paciente.get(params.id)
        if (!paciente) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'paciente.label', default: 'Paciente'), params.id])
            redirect(action: "lista")
        }
        else {
            return [paciente: paciente]
        }
    }

    def actualiza = {
        def paciente = Paciente.get(params.id)
        if (paciente) {
            if (params.version) {
                def version = params.version.toLong()
                if (paciente.version > version) {
                    
                    paciente.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'paciente.label', default: 'Paciente')] as Object[], "Another user has updated this Paciente while you were editing")
                    render(view: "edita", model: [paciente: paciente])
                    return
                }
            }
            paciente.properties = params
            if (!paciente.hasErrors() && paciente.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'paciente.label', default: 'Paciente'), paciente.id])
                redirect(action: "ver", id: paciente.id)
            }
            else {
                render(view: "edita", model: [paciente: paciente])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'paciente.label', default: 'Paciente'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def paciente = Paciente.get(params.id)
        if (paciente) {
            try {
                paciente.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'paciente.label', default: 'Paciente'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'paciente.label', default: 'Paciente'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'paciente.label', default: 'Paciente'), params.id])
            redirect(action: "lista")
        }
    }
}
