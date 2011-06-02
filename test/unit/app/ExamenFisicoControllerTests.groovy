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
        for(i in 1..20) {
            examenFisicos << new ExamenFisico(
                peso: i
                ,talla: i
                ,respiraciones: i
                ,pulso: i
                ,presionSistolica: i
                ,presionDiastolica: i
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

        params.peso = 1

        controller.crea()
        assert '/examenFisico/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraVerExamenFisico() {
        def examenFisicos = []
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i
                ,version:1
                ,peso: i
                ,talla: i
                ,respiraciones: i
                ,pulso: i
                ,presionSistolica: i
                ,presionDiastolica: i
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.ver()
        assert model.examenFisico.peso == 1
    }

    @Test
    void debieraActualizarExamenFisico() {
        def examenFisicos = []
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i
                ,version:1
                ,peso: i
                ,talla: i
                ,respiraciones: i
                ,pulso: i
                ,presionSistolica: i
                ,presionDiastolica: i
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.edita()
        assert model.examenFisico.peso == 1

        params.id = 1
        params.peso = 123
        model = controller.actualiza()
        assert '/examenFisico/ver/1' == response.redirectedUrl
    }

    @Test
    void debieraEliminarExamenFisico() {
        def examenFisicos = []
        for(i in 1..2) {
            examenFisicos << new ExamenFisico(
                id:i
                ,version:1
                ,dpeso: i
                ,talla: i
                ,respiraciones: i
                ,pulso: i
                ,presionSistolica: i
                ,presionDiastolica: i
            )
        }
        mockDomain(ExamenFisico, examenFisicos)

        params.id = 1
        def model = controller.edita()
        assert model.examenFisicos.peso == 1

        params.id = 1
        controller.elimina()
        assert '/examenFisico/lista' == response.redirectedUrl
    }

}