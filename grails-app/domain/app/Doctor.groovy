package app

class Doctor {
    String cedula
    String nombre
    String apellidoPaterno
    String apellidoMaterno
    String especialidades
    String correo
    Set consulta

    static hasMany = [consulta:Consulta]

    static constraints = {
        cedula(maxSize:64,blank:false)
        nombre(maxSize:64,blank:false)
        apellidoPaterno(maxSize:64,blank:false)
        apellidoMaterno(maxSize:64,nullable:true)
        especialidades(nullable:true)
        correo(maxSize:128,nullable:true)
        consulta(nullable:true)
    }

    String toString() {
        return "$cedula : $apellidoPaterno, $nombre"
    }
}
