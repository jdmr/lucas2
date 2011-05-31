package app

import grails.converters.JSON

class ExamenFisicoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [examenfisicos: ExamenFisico.list(params), totalDeExamenFisicos: ExamenFisico.count()]
    }

    def nuevo = {
        def examenfisico = new ExamenFisico()
        examenfisico.properties = params
        return [examenfisico: examenfisico]
    }

    def crea = {
        def examenfisico = new ExamenFisico(params)
        if (examenfisico.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), examenfisico.id])
            redirect(action: "ver", id: examenfisico.id)
        }
        else {
            log.debug("Hubo errores al intentar crear al examenfisico ${examenfisico.errors}")
            render(view: "nuevo", model: [examenfisico: examenfisico])
        }
    }

    def ver = {
        def examenfisico = ExamenFisico.get(params.id)
        if (!examenfisico) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), params.id])
            redirect(action: "lista")
        }
        else {
            [examenfisico: examenfisico]
        }
    }

    def edita = {
        def examenfisico = ExamenFisico.get(params.id)
        if (!examenfisico) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), params.id])
            redirect(action: "lista")
        }
        else {
            return [examenfisico: examenfisico]
        }
    }

    def actualiza = {
        def examenfisico = ExamenFisico.get(params.id)
        if (examenfisico) {
            if (params.version) {
                def version = params.version.toLong()
                if (examenfisico.version > version) {

                    examenfisico.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'examenfisico.label', default: 'ExamenFisico')] as Object[], "Another user has updated this ExamenFisico while you were editing")
                    render(view: "edita", model: [examenfisico: examenfisico])
                    return
                }
            }
            examenfisico.properties = params
            if (!examenfisico.hasErrors() && examenfisico.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), examenfisico.id])
                redirect(action: "ver", id: examenfisico.id)
            }
            else {
                render(view: "edita", model: [examenfisico: examenfisico])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def examenfisico = ExamenFisico.get(params.id)
        if (examenfisico) {
            try {
                examenfisico.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'examenfisico.label', default: 'ExamenFisico'), params.id])
            redirect(action: "lista")
        }
    }
}
