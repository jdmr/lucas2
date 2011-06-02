package app



import org.junit.*
import grails.test.mixin.*


@TestFor(DoctorController)
@Mock(Doctor)
class DoctorControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/doctor/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.doctorInstanceList.size() == 0
        assert model.doctorInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.doctorInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.doctorInstance != null
        assert view == '/doctor/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/doctor/show/1'
        assert controller.flash.message != null
        assert Doctor.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'


        def doctor = new Doctor()

        // TODO: populate domain properties

        assert doctor.save() != null

        params.id = doctor.id

        def model = controller.show()

        assert model.doctorInstance == doctor
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'


        def doctor = new Doctor()

        // TODO: populate valid domain properties

        assert doctor.save() != null

        params.id = doctor.id

        def model = controller.edit()

        assert model.doctorInstance == doctor
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'

        response.reset()


        def doctor = new Doctor()

        // TODO: populate valid domain properties

        assert doctor.save() != null

        // test invalid parameters in update
        params.id = doctor.id

        controller.update()

        assert view == "/doctor/edit"
        assert model.doctorInstance != null

        doctor.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/doctor/show/$doctor.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/doctor/list'

        response.reset()

        def doctor = new Doctor()

        // TODO: populate valid domain properties
        assert doctor.save() != null
        assert Doctor.count() == 1

        params.id = doctor.id

        controller.delete()

        assert Doctor.count() == 0
        assert Doctor.get(doctor.id) == null
        assert response.redirectedUrl == '/doctor/list'


    }


}