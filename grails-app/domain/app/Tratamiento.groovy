package app

class Tratamiento {
    String descripcion
    String medicina
    String dosis
    String frecuencia
    Date inicia
    Date termina
    Date dateCreated
    Date lastUpdated
    Consulta consulta

    static belongsTo = [consulta:Consulta]

    static constraints = {
        descripcion(maxSize:700,nullable:true)
        medicina(maxSize:128,nullable:true)
        dosis(maxSize:128,nullable:true)
        frecuencia(maxSize:128,nullable:true)
        inicia(nullable:true)
        termina(nullable:true)
    }
}
