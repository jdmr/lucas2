package app

class Paciente {
    String expediente
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    Date fechaNacimiento
    Boolean esHombre = true
    Date dateCreated
    Date lastUpdated

    static constraints = {
        expediente(maxSize:64,blank:false,unique:true)
        nombre(maxSize:64,blank:false)
        apellidoPaterno(maxSize:64,blank:false)
        apellidoMaterno(maxSize:64,blank:false)
        fechaNacimiento()
        esHombre()
    }

    String toString() {
        return "$expediente : $apellidoPaterno, $apellidoMaterno"
    }
}
