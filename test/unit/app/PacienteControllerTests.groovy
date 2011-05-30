package app

import org.junit.*
import grails.test.mixin.*

@TestFor(PacienteController)
@Mock(Paciente)
class PacienteControllerTests {


    @Test
    void indexDebieraHacerRedirectALista() {
        controller.index()
        assert "/paciente/lista" == response.redirectedUrl
    }

    @Test
    void debieraMostrarListaDePacientes() {
        def pacientes = []
        for(i in 1..20) {
            pacientes << new Paciente(
                expediente: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,fechaNacimiento: new Date()
            )
        }
        mockDomain(Paciente, pacientes)

        def model = controller.lista()

        assert model.pacientes.size() == 10
        assert model.totalDePacientes == 20
    }

    @Test
    void debieraCrearUnPaciente() {
        def model = controller.nuevo()
        assert model.paciente != null

        params.expediente = 'TEST1'
        params.nombre = 'TEST1'
        params.apellidoPaterno = 'TEST'
        params.apellidoMaterno = 'TEST'
        params.fechaNacimiento = new Date()

        controller.crea()
        assert '/paciente/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerPaciente() {
        def pacientes = []
        for(i in 1..2) {
            pacientes << new Paciente(
                id:i,
                ,version:1
                ,expediente: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,fechaNacimiento: new Date()
            )
        }
        mockDomain(Paciente, pacientes)

        params.id = 1
        def model = controller.ver()
        assert model.paciente.expediente == 'TEST1'
    }

    @Test
    void debieraActualizarPaciente() {
        def pacientes = []
        for(i in 1..2) {
            pacientes << new Paciente(
                id:i,
                ,version:1
                ,expediente: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,fechaNacimiento: new Date()
            )
        }
        mockDomain(Paciente, pacientes)

        params.id = 1
        def model = controller.edita()
        assert model.paciente.nombre == 'TEST1'
        
        params.id = 1
        params.nombre = 'PRUEBA'
        model = controller.actualiza()
        assert '/paciente/ver/1' == response.redirectedUrl
    }
    
    @Test
    void debieraEliminarPaciente() {
        def pacientes = []
        for(i in 1..2) {
            pacientes << new Paciente(
                id:i,
                ,version:1
                ,expediente: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,fechaNacimiento: new Date()
            )
        }
        mockDomain(Paciente, pacientes)

        params.id = 1
        def model = controller.edita()
        assert model.paciente.nombre == 'TEST1'
        
        params.id = 1
        controller.elimina()
        assert '/paciente/lista' == response.redirectedUrl
    }

}
