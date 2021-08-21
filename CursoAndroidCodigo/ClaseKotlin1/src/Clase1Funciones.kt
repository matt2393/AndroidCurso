
fun fact(x: Int = 0) {
    var res = 1
    for(i in 1..x) {
        res *=i
    }
    println(res)
}
fun fact2(x: Int): Int {
    var res = 1
    for(i in 1..x) {
        res *=i
    }
    return res
}

fun fact3(x: Int) = run {
    var res = 1
    for(i in 1..x) {
        res *=i
    }
    res
}
fun sumatoria(x: Int) = x*(x+1)/2

var sumatoria2 = { x: Int -> Int
    x*(x+1)/2
}

fun fact4(x: Int, sum3:(Int)->Unit) {
    var res = 1
    for(i in 1..x) {
        res *=i
    }
    println(res)
    sum3(res)
}
fun sum5(vararg x: Int): Int {
    var s = 0
    for (i in x) {
        s+=i
    }
    return s
}
fun sumAux(a: Int = 4, b: Int) = a+b

fun main() {
    //fact(5)
    val aux = fact3(6)
    //println(aux*2)
    //println(sumatoria(100))
    //println(sumatoria2(100))
    /*fact4(5) { x->
        val s = x*(x+1)/2
        println(s)
    }*/
    println(sum5(2, 5,2, 5,2, 5,2, 5,2, 5,2, 5,2, 5))
    sumAux(2, b= 7)
}