package app

class Diagnostico {
    String nombre

    static constraints = {
        nombre(maxSize:128,blank:false)
    }

    String toString() {
        nombre
    }
}
