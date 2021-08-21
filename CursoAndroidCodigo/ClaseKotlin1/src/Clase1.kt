/**
 * Clase 1, 3 de agosto 2021
 */

fun main() {
    var edad = 18
    var texto = if(edad <= 17) {
        edad *= 2
        ///
        //
        //
        "Menor de edad $edad"
    } else {
        ///
        "Mayor de edad"
    }
    //println(texto)
    /**
     * for('variable almacenar el valor' in 'rango')
     */
    for(i in 0..5) {
        //println(i)
    }
    for(i in 0 until 5) {
        //println(i)
    }

    // editar el valor de incremento
    for(i in 0..10 step 2) {
        //println(i)
    }
    //en reversa, step decrementa
    for(i in 10 downTo 0 step 2) {
       // println(i)
    }

    /**
     * condicional multiple
     * no se usa el switch
     * when
     */
    var x: Any = 7.0
   /* when(x) {
        in 0..5 -> print("entre 0 y 5")
       // in 6..10 -> print("esta entre 6 y 7")
        11 -> print("es 11")
        is Int -> print("es entero")
        is String -> print("Es string")
        is Float -> print("es Float")
        else -> print("No es ninguno")
    }*/
    //asignar a un variable con la condicional multiple
    var text2 = when(x) {
        in 0..5 -> "entre 0 y 5"
        // in 6..10 -> print("esta entre 6 y 7")
        11 -> "es 11"
        is Int -> "es entero"
        is String -> "Es string"
        is Float -> "es Float"
        else -> "No es ninguno"
    }
    //println(text2)
    /**
     * while
     */
   /* while (x is Double) {
        println(x)
        x= 1
    }*/
}