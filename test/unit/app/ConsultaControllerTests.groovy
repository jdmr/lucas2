package app



import org.junit.*
import grails.test.mixin.*


@TestFor(ConsultaController)
@Mock(Consulta)
class ConsultaControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/consulta/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.consultaInstanceList.size() == 0
        assert model.consultaInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.consultaInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.consultaInstance != null
        assert view == '/consulta/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/consulta/show/1'
        assert controller.flash.message != null
        assert Consulta.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/consulta/list'


        def consulta = new Consulta()

        // TODO: populate domain properties

        assert consulta.save() != null

        params.id = consulta.id

        def model = controller.show()

        assert model.consultaInstance == consulta
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/consulta/list'


        def consulta = new Consulta()

        // TODO: populate valid domain properties

        assert consulta.save() != null

        params.id = consulta.id

        def model = controller.edit()

        assert model.consultaInstance == consulta
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/consulta/list'

        response.reset()


        def consulta = new Consulta()

        // TODO: populate valid domain properties

        assert consulta.save() != null

        // test invalid parameters in update
        params.id = consulta.id

        controller.update()

        assert view == "/consulta/edit"
        assert model.consultaInstance != null

        consulta.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/consulta/show/$consulta.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/consulta/list'

        response.reset()

        def consulta = new Consulta()

        // TODO: populate valid domain properties
        assert consulta.save() != null
        assert Consulta.count() == 1

        params.id = consulta.id

        controller.delete()

        assert Consulta.count() == 0
        assert Consulta.get(consulta.id) == null
        assert response.redirectedUrl == '/consulta/list'


    }


}