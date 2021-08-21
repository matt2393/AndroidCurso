
/**
 * PARADIGMAS
 *
 * Procedimental
 * Funcional
 * Oriantada a Objetos
 */

/**
 * En kotlin no es necesario el punto y coma
 * ;
 */
/**
 * val ->  constante, valor que no cambia
 * var ->  una variable, valor que cambia constantemente
 */

/**
 * Programación Procedimental
 */
var x = 5
var y = 5.5
var z = 3f
var w = 8L
var h = 'h'
var g = "dd"

var a: Int? = 2
var b: String? = null
var c: String = ""
val o: Boolean? = true

fun main() {
    b = "nombre"
    println(b?.length)
    if(b!!.length > 5) {
        println("Si es mayor")
    } else {
        println("Es Menor")
    }
    //println(b?.length)
    //o = false
    println("Hola Mundo")
}