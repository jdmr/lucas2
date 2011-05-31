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
//        def doctors = []
//        for(i in 1..2) {
//            doctors << new Doctor(
//                id:i,
//                ,version:1
//                ,cedula: "TEST$i"
//                ,nombre: "TEST$i"
//                ,apellidoPaterno: "TEST$i"
//                ,apellidoMaterno: "TEST$i"
//                ,especialidades: 'TEST1,TEST2,TEST3'
//            )
//        }
//        mockDomain(Paciente)
//        mockDomain(Consulta)
//        def pacientes = []
//        for(i in 1..2) {
//            pacientes << new Paciente(
//                expediente: "TEST$i"
//                ,nombre: "TEST$i"
//                ,apellidoPaterno: "TEST$i"
//                ,apellidoMaterno: "TEST$i"
//                ,fechaNacimiento: new Date()
//            )
//        }
//        mockDomain(Paciente, pacientes)
//        def consulta = new Consulta(
//        )
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i,
                ,version:1
                ,peso: 100
                ,talla: 180
                ,respiraciones: 20
                ,pulso:60
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
        assert model.examenfisico != null

        params.peso = 100
        params.talla = 180
        params.respiraciones = 20
        params.pulso = 60
        params.presionSistolica = 120
        params.presionDiastolica = 60
        params.paciente= paciente
        params.consulta= consulta

        controller.crea()
        assert '/examenFisico/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerExamenFisico() {
        def examenFisicos = []
        def paciente = new Paciente()
        def consulta = new Consulta()
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i
                ,version: 1
                ,peso: 100
                ,talla: 180
                ,respiraciones: 20
                ,pulso: 60
                ,presionSistolica: 120
                ,presionDiastolica: 60
                ,paciente:paciente
                ,consulta:consulta
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.ver()
        assert model.examenFisico.peso == '150'
    }

    @Test
    void debieraActualizarExamenFisico() {
        def examenFisicos = []
        for(i in 1..20) {
            examenFisicos << new ExamenFisico(
                id:i
                ,version: 1
                ,peso: 100
                ,talla: 180
                ,respiraciones: 20
                ,pulso: 60
                ,presionSistolica: 120
                ,presionDiastolica: 60
                ,paciente:paciente
                ,consulta:consulta
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.edita()
        assert model.examenFisico.peso == '160'
        
        params.id = 1
        params.nombre = 'PRUEBA'
        model = controller.actualiza()
        assert '/examenFisico/ver/1' == response.redirectedUrl
    }
    
    @Test
    void debieraEliminarExamenFisico() {
        def examenFisicos = []
        for(i in 1..20) {
            examenFisicos << new ExamenFisico(
                id:i
                ,version: 1
                ,peso: 100
                ,talla: 180
                ,respiraciones: 20
                ,pulso: 60
                ,presionSistolica: 120
                ,presionDiastolica: 60
                ,paciente:paciente
                ,consulta:consulta
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