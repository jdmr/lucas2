package app

class Consulta {
    String descripcion
    Doctor doctor
    Paciente paciente
    Set examenFisico
    Set sintomas
    Set diagnosticos
    Set tratamientos
    Date dateCreated
    Date lastUpdated

    static belongsTo = [doctor:Doctor, paciente:Paciente]

    static hasMany = [diagnosticos:Diagnostico, tratamientos:Tratamiento, sintomas:Sintoma, examenFisicos:ExamenFisico]

    static constraints = {
        descripcion(maxSize:700)
        examenFisico(nullable:true)
        sintomas(nullable:true)
        diagnosticos(nullable:true)
        tratamientos(nullable:true)
    }
}
