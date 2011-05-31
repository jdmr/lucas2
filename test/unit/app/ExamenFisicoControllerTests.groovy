package app

import org.junit.*
import grails.test.mixin.*

@TestFor(ExamenFisicoController)
@Mock(ExamenFisico)
class ExamenFisicoControllerTests {


    @Test
    void indexDebieraHacerRedirectALista() {
        controller.index()
        assert "/examenFisico/lista" == response.redirectedUrl
    }

    @Test
    void debieraMostrarListaDeExamenFisicos() {
        def examenFisicos = []
        mockDomain(Paciente)
        mockDomain(Consulta)
        def paciente = new Paciente(
            id:i,
            ,version:1
            ,expediente: "TEST$i"
            ,nombre: "TEST$i"
            ,apellidoPaterno: "TEST$i"
            ,apellidoMaterno: "TEST$i"
            ,fechaNacimiento: new Date()
        )
        def consulta = new Consulta(
        )
        for(i in 1..20) {
            examenFisicos << new ExamenFisico(
                peso: 100
                ,talla: 180
                ,respiraciones: 20
                ,presionSistolica: 120
                ,presionDiastolica: 60
                ,paciente:paciente
                ,consulta:consulta
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        def model = controller.lista()

        assert model.examenFisicos.size() == 10
        assert model.totalDeExamenFisicos == 20
    }

    @Test
    void debieraCrearUnExamenFisico() {
        def model = controller.nuevo()
        assert model.examenFisico != null

        params.expediente = 'TEST1'
        params.nombre = 'TEST1'
        params.apellidoPaterno = 'TEST'
        params.apellidoMaterno = 'TEST'
        params.fechaNacimiento = new Date()

        controller.crea()
        assert '/examenFisico/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerExamenFisico() {
        def examenFisicos = []
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i,
                ,version:1
                ,expediente: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,fechaNacimiento: new Date()
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.ver()
        assert model.examenFisico.expediente == 'TEST1'
    }

    @Test
    void debieraActualizarExamenFisico() {
        def examenFisicos = []
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i,
                ,version:1
                ,expediente: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,fechaNacimiento: new Date()
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.edita()
        assert model.examenFisico.nombre == 'TEST1'
        
        params.id = 1
        params.nombre = 'PRUEBA'
        model = controller.actualiza()
        assert '/examenFisico/ver/1' == response.redirectedUrl
    }
    
    @Test
    void debieraEliminarExamenFisico() {
        def examenFisicos = []
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i,
                ,version:1
                ,expediente: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,fechaNacimiento: new Date()
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.edita()
        assert model.examenFisico.nombre == 'TEST1'
        
        params.id = 1
        controller.elimina()
        assert '/examenFisico/lista' == response.redirectedUrl
    }

}
