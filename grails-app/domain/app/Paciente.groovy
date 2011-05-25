package app

class Paciente {
    String expediente
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    Date fechaNacimiento
    Boolean esHombre = true
    String correo
    Date dateCreated
    Date lastUpdated

    static constraints = {
        expediente(maxSize:64,blank:false,unique:true)
        nombre(maxSize:64,blank:false)
        apellidoPaterno(maxSize:64,blank:false)
        apellidoMaterno(maxSize:64,blank:false)
        fechaNacimiento()
        esHombre()
        correo(maxSize:128,nullable:true)
    }

    String toString() {
        return "$expediente : $apellidoPaterno, $apellidoMaterno"
    }
}
