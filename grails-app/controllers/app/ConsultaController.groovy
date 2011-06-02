package app

import grails.converters.JSON

class ConsultaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
	params.max = Math.min(params.max ? params.int('max') : 10, 100)
	[consultas: Consulta.list(params), totalDeConsultas: Consulta.count()]
    }

    def nuevo = {
        def consulta = new Consulta()
        consulta.properties = params
        return [consulta: consulta]
    }

    def crea = {
        def consulta = new Consulta(params)
        if (consulta.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'consulta.label', default: 'Consulta'), consulta.id])
            redirect(action: "ver", id: consulta.id)
        }
        else {
            render(view: "nuevo", model: [consulta: consulta])
        }
    }

    def ver = {
        def consulta = Consulta.get(params.id)
        if (!consulta) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "lista")
        }
        else {
            [consulta: consulta]
        }
    }

    def edita = {
        log.debug("Editando consulta")
        def consulta = Consulta.get(params.id)
        if (!consulta) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "lista")
        }
//        else {
//            def sintomas = new StringBuilder()
//            for(sintoma in consulta.sintomas) {
//                if (sintomas.length > 0) {
//                    sintomas.append(",")
//                }
//                sintomas.append(sintoma.nombre)
//            }
//            return [consulta: consulta, sintomas: sintomas.toString()]
//        }
        else {
            [consulta: consulta]
        }
    }

    def actualiza = {
        def consulta = Consulta.get(params.id)
        if (consulta) {
            if (params.version) {
                def version = params.version.toLong()
                if (consulta.version > version) {
                    
                    consulta.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'consulta.label', default: 'Consulta')] as Object[], "Another user has updated this Consulta while you were editing")
                    render(view: "edita", model: [consulta: consulta])
                    return
                }
            }
            consulta.properties = params
            if (!consulta.hasErrors() && consulta.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'consulta.label', default: 'Consulta'), consulta.id])
                redirect(action: "ver", id: consulta.id)
            }
            else {
                render(view: "edita", model: [consulta: consulta])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def consulta = Consulta.get(params.id)
        if (consulta) {
            try {
                consulta.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), params.id])
            redirect(action: "lista")
        }
    }

//    def sintomas = {
//        log.info("Params: $params")
//        def resultado = []
//
//        def lista = Sintoma.findAllByNombreIlike("%${params.q}%")
//        for(sintoma in lista) {
//            resultado << [id:sintoma.id,value:sintoma.nombre]
//        }
//
//        log.info("Resultado: ${resultado as grails.converters.JSON}")
//
//        render resultado as grails.converters.JSON
//    }

}
