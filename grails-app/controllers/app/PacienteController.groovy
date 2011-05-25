package app

class PacienteController {

    def scaffold = Paciente

    def hola() {
        log.debug("Hola mundo")
        render("HOLA MUNDO!")
    }
}
