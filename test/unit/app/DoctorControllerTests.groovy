package app

import org.junit.*
import grails.test.mixin.*

@TestFor(DoctorController)
@Mock(Doctor)
class DoctorControllerTests {


    @Test
    void indexDebieraHacerRedirectALista() {
        controller.index()
        assert "/doctor/lista" == response.redirectedUrl
    }

    @Test
    void debieraMostrarListaDeDoctors() {
        def doctors = []
        for(i in 1..20) {
            doctors << new Doctor(
                cedula: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,especialidades: 'TEST1,TEST2,TEST3'
            )
        }
        mockDomain(Doctor, doctors)

        def model = controller.lista()

        assert model.doctors.size() == 10
        assert model.totalDeDoctors == 20
    }

    @Test
    void debieraCrearUnDoctor() {
        def model = controller.nuevo()
        assert model.doctor != null

        params.cedula = 'TEST1'
        params.nombre = 'TEST1'
        params.apellidoPaterno = 'TEST'
        params.apellidoMaterno = 'TEST'
        params.especialidades = 'TEST1,TEST2,TEST3'

        controller.crea()
        assert '/doctor/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerDoctor() {
        def doctors = []
        for(i in 1..2) {
            doctors << new Doctor(
                id:i,
                ,version:1
                ,cedula: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,especialidades: 'TEST1,TEST2,TEST3'
            )
        }
        mockDomain(Doctor, doctors)

        params.id = 1
        def model = controller.ver()
        assert model.doctor.cedula == 'TEST1'
    }

    @Test
    void debieraActualizarDoctor() {
        def doctors = []
        for(i in 1..2) {
            doctors << new Doctor(
                id:i,
                ,version:1
                ,cedula: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,especialidades: 'TEST1,TEST2,TEST3'
            )
        }
        mockDomain(Doctor, doctors)

        params.id = 1
        def model = controller.edita()
        assert model.doctor.nombre == 'TEST1'
        
        params.id = 1
        params.nombre = 'PRUEBA'
        model = controller.actualiza()
        assert '/doctor/ver/1' == response.redirectedUrl
    }
    
    @Test
    void debieraEliminarDoctor() {
        def doctors = []
        for(i in 1..2) {
            doctors << new Doctor(
                id:i,
                ,version:1
                ,cedula: "TEST$i"
                ,nombre: "TEST$i"
                ,apellidoPaterno: "TEST$i"
                ,apellidoMaterno: "TEST$i"
                ,especialidades: 'TEST1,TEST2,TEST3'
            )
        }
        mockDomain(Doctor, doctors)

        params.id = 1
        def model = controller.edita()
        assert model.doctor.nombre == 'TEST1'
        
        params.id = 1
        controller.elimina()
        assert '/doctor/lista' == response.redirectedUrl
    }

}
