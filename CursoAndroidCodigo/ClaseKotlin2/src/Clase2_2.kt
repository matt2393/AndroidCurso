

fun main() {
    var x: Array<Int> = Array(5) { 0 }
    x[1] = 3
    var y = arrayOf(1,3,5)
    //println(x.toString())
    for(i in x) {
       // println(i)
    }
    x.forEach {
       // println(it)
    }
    x.forEachIndexed { index, i ->
        if(index == 2) {
           // println(i+2)
        } else {
            //println(i)
        }
    }

    var datos: ArrayList<Int>? = null
    datos?.add(9)
    datos?.add(5)
    datos?.add(1)
    //println(datos)
    var datos2 = arrayListOf("a")
    var datos3 = arrayListOf<Float>()

    //apply devuelve la instancia antes de asignarla
    var datos4 = arrayListOf(1,2,3,6).apply {

    }
    //also devuelve en una variable la instancia antes de asignarla
    var datos5 = arrayListOf(1,2,3,6).also {
    }

    var aux: Int = 0
    //aux = datos[1]
    datos?.let {
        aux = it[1]
    }

    var map = HashMap<String, Int>()
    map["primero"] = 2
    map["otro"] = 5
    map["otro2"] = 7
    map["otro3"] = 6

    var map2 = HashMap<String, Int>().apply {
        put("primero",6)
    }
}

fun getMap(): HashMap<String, Int> {
    var map = HashMap<String, Int>()
    map["primero"] = 2
    map["otro"] = 5
    map["otro2"] = 7
    map["otro3"] = 6
    return map
}
fun getMap2() = HashMap<String, Int>().apply {

}