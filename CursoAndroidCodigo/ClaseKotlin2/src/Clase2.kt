/**
 * Constructor
 * Encapsulamiento
 *    - private -> solo la clase puede acceder
 *    - public -> todos pueden usarlo
 *    - protected -> solo la clase y sus herederas
 * Herenecia
 *    - herenecia simple, solo se puede heredar de una clase
 *    - herencia multiple, se puede heredar de muchas interfaces
 * Polimorfismo
 */
class Matriz(val filas: Int = 0, var cols: Int = 0) {
    constructor(casillas: Int) : this() {
    }
    constructor(algo: Int, i: Float): this(){

    }
    private fun genMat() {
    }
    fun mostrar() {

    }
    protected fun sumaMat() {

    }
}
class Matriz2 {
    constructor(casillas: Int) {

    }
    constructor(filas: Int, cols: Int) {

    }
}

/**
 * Herencia
 *
 */
open class Figura {
    protected fun area(): Double {
        return 5.0
    }
}
class Cuadrado: Figura() {
    fun al(){
        super.area()
    }
    fun perimetro() {
        ////code
    }
}

/**
 * clases abstractas
 * pueden o no implementar sus mótodos
 */
abstract class Vehiculo {
    abstract fun velocidad()
    fun getMotor() {

    }
}
abstract class Vehiculo2 {
    abstract fun velocidad()
    fun getMotor() {

    }
}
class Avion: Vehiculo() {
    override fun velocidad() {
       println("600km/h")
    }
}
class Moto: Vehiculo() {
    override fun velocidad() {
        println("120km/h")
    }

}

fun main() {
    var m = Matriz(cols = 8)
    var m2 = Matriz2(4)

    var f = Figura()

    var a : Any  = Avion()
    a = Moto()
    a = Avion()
    var b = Avion()

    (a as Vehiculo).velocidad()

}