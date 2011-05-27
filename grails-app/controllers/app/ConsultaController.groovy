package app

import grails.converters.JSON

class ConsultaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[consultaInstanceList: Consulta.list(params), consultaInstanceTotal: Consulta.count()]
	}

    def create = {
        def consultaInstance = new Consulta()
        consultaInstance.properties = params
        return [consultaInstance: consultaInstance]
    }

    def save = {
        def consultaInstance = new Consulta(params)
        if (consultaInstance.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'consulta.label', default: 'Consulta'), consultaInstance.id])
            redirect(action: "show", id: consultaInstance.id)
        }
        else {
            render(view: "create", model: [consultaInstance: consultaInstance])
        }
    }

    def show = {
        def consultaInstance = Consulta.get(params.id)
        if (!consultaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "list")
        }
        else {
            [consultaInstance: consultaInstance]
        }
    }

    def edit = {
        log.debug("Editando consulta")
        def consultaInstance = Consulta.get(params.id)
        if (!consultaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "list")
        }
        else {
            def sintomas = new StringBuilder()
            for(sintoma in consultaInstance.sintomas) {
                if (sintomas.length > 0) {
                    sintomas.append(",")
                }
                sintomas.append(sintoma.nombre)
            }
            return [consultaInstance: consultaInstance, sintomas: sintomas.toString()]
        }
    }

    def update = {
        def consultaInstance = Consulta.get(params.id)
        if (consultaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (consultaInstance.version > version) {
                    
                    consultaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'consulta.label', default: 'Consulta')] as Object[], "Another user has updated this Consulta while you were editing")
                    render(view: "edit", model: [consultaInstance: consultaInstance])
                    return
                }
            }
            consultaInstance.properties = params
            if (!consultaInstance.hasErrors() && consultaInstance.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'consulta.label', default: 'Consulta'), consultaInstance.id])
                redirect(action: "show", id: consultaInstance.id)
            }
            else {
                render(view: "edit", model: [consultaInstance: consultaInstance])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "list")
        }
    }

    def delete = {
        def consultaInstance = Consulta.get(params.id)
        if (consultaInstance) {
            try {
                consultaInstance.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "list")
        }
    }

    def sintomas = {
        log.info("Params: $params")
        def resultado = []

        def lista = Sintoma.findAllByNombreIlike("%${params.q}%")
        for(sintoma in lista) {
            resultado << [id:sintoma.id,value:sintoma.nombre]
        }

        log.info("Resultado: ${resultado as grails.converters.JSON}")

        render resultado as grails.converters.JSON
    }

}
