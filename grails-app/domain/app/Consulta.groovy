package app

class Consulta {
    String descripcion
    Doctor doctor
    ExamenFisico examenFisico
    Set sintomas
    Set diagnosticos
    //Diagnostico diagnosticoPrincipal
    Set tratamientos
    Date dateCreated
    Date lastUpdated

    //static belongsTo = [doctor:Doctor, diagnosticoPrincipal:Diagnostico]
    static belongsTo = [doctor:Doctor]

    static hasMany = [diagnosticos: Diagnostico, tratamientos: Tratamiento, sintomas: Sintoma]

    static constraints = {
        descripcion(maxSize:700, nullable:true)
        examenFisico(nullable:true)
        sintomas()
        //diagnosticoPrincipal(nullable:true)
        diagnosticos()
        tratamientos()
    }
}
