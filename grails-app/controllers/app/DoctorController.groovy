package app

import grails.converters.JSON

class DoctorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "lista", params: params)
    }

    def lista = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [doctors: Doctor.list(params), totalDeDoctors: Doctor.count()]
    }

    def nuevo = {
        def doctor = new Doctor()
        doctor.properties = params
        return [doctor: doctor]
    }

    def crea = {
        def doctor = new Doctor(params)
        if (doctor.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'doctor.label', default: 'Doctor'), doctor.id])
            redirect(action: "ver", id: doctor.id)
        }
        else {
            log.debug("Hubo errores al intentar crear al doctor ${doctor.errors}")
            render(view: "nuevo", model: [doctor: doctor])
        }
    }

    def ver = {
        def doctor = Doctor.get(params.id)
        if (!doctor) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), params.id])
            redirect(action: "lista")
        }
        else {
            [doctor: doctor]
        }
    }

    def edita = {
        def doctor = Doctor.get(params.id)
        if (!doctor) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), params.id])
            redirect(action: "lista")
        }
        else {
            return [doctor: doctor]
        }
    }

    def actualiza = {
        def doctor = Doctor.get(params.id)
        if (doctor) {
            if (params.version) {
                def version = params.version.toLong()
                if (doctor.version > version) {

                    doctor.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'doctor.label', default: 'Doctor')] as Object[], "Another user has updated this Doctor while you were editing")
                    render(view: "edita", model: [doctor: doctor])
                    return
                }
            }
            doctor.properties = params
            if (!doctor.hasErrors() && doctor.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'doctor.label', default: 'Doctor'), doctor.id])
                redirect(action: "ver", id: doctor.id)
            }
            else {
                render(view: "edita", model: [doctor: doctor])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), params.id])
            redirect(action: "lista")
        }
    }

    def elimina = {
        def doctor = Doctor.get(params.id)
        if (doctor) {
            try {
                doctor.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'doctor.label', default: 'Doctor'), params.id])
                redirect(action: "lista")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'doctor.label', default: 'Doctor'), params.id])
                redirect(action: "ver", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), params.id])
            redirect(action: "lista")
        }
    }
}
