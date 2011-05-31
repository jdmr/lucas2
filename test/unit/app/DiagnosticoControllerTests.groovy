package app

import org.junit.*
import grails.test.mixin.*

@TestFor(DiagnosticoController)
@Mock(Diagnostico)
class DiagnosticoControllerTests {


    @Test
    void indexDebieraHacerRedirectALista() {
        controller.index()
        assert "/diagnostico/lista" == response.redirectedUrl
    }

    @Test
    void debieraMostrarListaDeDiagnosticos() {
        def diagnosticos = []
        for(i in 1..20) {
            diagnosticos << new Diagnostico(
                nombre: "TEST$i"
            )
        }
        mockDomain(Diagnostico, diagnosticos)

        def model = controller.lista()

        assert model.diagnosticos.size() == 10
        assert model.totalDeDiagnosticos == 20
    }

    @Test
    void debieraCrearUnDiagnostico() {
        def model = controller.nuevo()
        assert model.diagnostico != null

        params.nombre = 'TEST1'

        controller.crea()
        assert '/diagnostico/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerDiagnostico() {
        def diagnosticos = []
        for(i in 1..2) {
            diagnosticos << new Diagnostico(
                id:i,
                ,version:1
                ,nombre: "TEST$i"
            )
        }
        mockDomain(Diagnostico, diagnosticos)

        params.id = 1
        def model = controller.ver()
        assert model.diagnostico.nombre == 'TEST1'
    }

    @Test
    void debieraActualizarDiagnostico() {
        def diagnosticos = []
        for(i in 1..2) {
            diagnosticos << new Diagnostico(
                id:i,
                ,version:1
                ,nombre: "TEST$i"
            )
        }
        mockDomain(Diagnostico, diagnosticos)

        params.id = 1
        def model = controller.edita()
        assert model.diagnostico.nombre == 'TEST1'

        params.id = 1
        params.nombre = 'PRUEBA'
        model = controller.actualiza()
        assert '/diagnostico/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraEliminarDiagnostico() {
        def diagnosticos = []
        for(i in 1..2) {
            diagnosticos << new Diagnostico(
                id:i,
                ,version:1
                ,nombre: "TEST$i"
            )
        }
        mockDomain(Diagnostico, diagnosticos)

        params.id = 1
        def model = controller.edita()
        assert model.diagnostico.nombre == 'TEST1'

        params.id = 1
        controller.elimina()
        assert '/diagnostico/lista' == response.redirectedUrl
    }

}

