package app



import grails.test.mixin.*
import org.junit.*

@TestFor(SintomaController)
@Mock(Sintoma)
class SintomaControllerTests {

      @Test
    void indexDebieraHacerRedirectALista() {
        controller.index()
        assert "/sintoma/lista" == response.redirectedUrl
    }

    @Test
    void debieraMostrarListaDeSintomas() {
        def sintomas = []
        for(i in 1..20) {
            sintomas << new Sintoma(
                nombre: "TEST$i"
            )
        }
        mockDomain(Sintoma, sintomas)

        def model = controller.lista()

        assert model.sintomas.size() == 10
        assert model.totalDeSintomas == 20
    }

    @Test
    void debieraCrearUnSintomas() {
        def model = controller.nuevo()
        assert model.sintoma != null

        params.nombre = 'TEST1'

        controller.crea()
        assert '/sintoma/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerSintoma() {
        def sintomas = []
        for(i in 1..2) {
            sintomas << new Sintoma(
                id:i,
                ,version:1
                ,nombre: "TEST$i"
            )
        }
        mockDomain(Sintoma, sintomas)

        params.id = 1
        def model = controller.ver()
        assert model.sintoma.nombre == 'TEST1'
    }

    @Test
    void debieraActualizarSintoma() {
        def sintomas = []
        for(i in 1..2) {
            sintomas << new Sintoma(
                id:i,
                ,version:1
                ,nombre: "TEST$i"
            )
        }
        mockDomain(Sintoma, sintomas)

        params.id = 1
        def model = controller.edita()
        assert model.sintoma.nombre == 'TEST1'

        params.id = 1
        params.nombre = 'PRUEBA'
        model = controller.actualiza()
        assert '/sintoma/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraEliminarSintoma() {
        def sintomas = []
        for(i in 1..2) {
            sintomas << new Sintoma(
                id:i,
                ,version:1
                ,nombre: "TEST$i"
            )
        }
        mockDomain(Sintoma, sintomas)

        params.id = 1
        def model = controller.edita()
        assert model.sintoma.nombre == 'TEST1'

        params.id = 1
        controller.elimina()
        assert '/sintoma/lista' == response.redirectedUrl
    }

}
