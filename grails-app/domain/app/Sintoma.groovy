package app

class Sintoma {
    String nombre

    static constraints = {
        nombre(maxSize:64, blank:false)
    }

    String toString() {
        nombre
    }
}
