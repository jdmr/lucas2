package app

import org.junit.*
import grails.test.mixin.*

@TestFor(TratamientoController)
@Mock(Tratamiento)
class TratamientoControllerTests {


    @Test
    void indexDebieraHacerRedirectALista() {
        controller.index()
        assert "/tratamiento/lista" == response.redirectedUrl
    }

    @Test
    void debieraMostrarListaDeTratamientos() {
        def tratamientos = []
        for(i in 1..20) {
            tratamientos << new Tratamiento(
                descripcion: "TEST$i"
            )
        }
        mockDomain(Tratamiento, tratamientos)

        def model = controller.lista()

        assert model.tratamientos.size() == 10
        assert model.totalDeTratamientos == 20
    }

    @Test
    void debieraCrearUnTratamiento() {
        def model = controller.nuevo()
        assert model.tratamiento != null

        params.descripcion = 'TEST1'

        controller.crea()
        assert '/tratamiento/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerTratamiento() {
        def tratamientos = []
        for(i in 1..2) {
            tratamientos << new Tratamiento(
                id:i
                ,version:1
                ,descripcion: "TEST$i"
                ,medicina: "TEST$i"
                ,dosis: "TEST$i"
                ,frecuencia: "TEST$i"
            )
        }
        mockDomain(Tratamiento, tratamientos)

        params.id = 1
        def model = controller.ver()
        assert model.tratamiento.descripcion == 'TEST1'
    }

    @Test
    void debieraActualizarTratamiento() {
        def tratamientos = []
        for(i in 1..2) {
            tratamientos << new Tratamiento(
                id:i
                ,version:1
                ,descripcion: "TEST$i"
                ,medicina: "TEST$i"
                ,dosis: "TEST$i"
                ,frecuencia: "TEST$i"
            )
        }
        mockDomain(Tratamiento, tratamientos)

        params.id = 1
        def model = controller.edita()
        assert model.tratamiento.descripcion == 'TEST1'

        params.id = 1
        params.descripcion = 'PRUEBA'
        model = controller.actualiza()
        assert '/tratamiento/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraEliminarTratamiento() {
        def tratamientos = []
        for(i in 1..2) {
            tratamientos << new Tratamiento(
                id:i
                ,version:1
                ,descripcion: "TEST$i"
                ,medicina: "TEST$i"
                ,dosis: "TEST$i"
                ,frecuencia: "TEST$i"
            )
        }
        mockDomain(Tratamiento, tratamientos)

        params.id = 1
        def model = controller.edita()
        assert model.tratamiento.descripcion == 'TEST1'

        params.id = 1
        controller.elimina()
        assert '/tratamiento/lista' == response.redirectedUrl
    }

}