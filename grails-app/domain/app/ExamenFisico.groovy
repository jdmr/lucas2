package app

class ExamenFisico {
    BigDecimal peso
    Integer talla
    Integer respiraciones
    Integer pulso
    Integer presionSistolica
    Integer presionDiastolica
    Date dateCreated
    Date lastUpdated

    static constraints = {
        peso(scale:3, precision:8)
        talla(scale:3, precision:8)
        respiraciones()
        pulso()
        presionSistolica()
        presionDiastolica()
        dateCreated()
    }
}
