
interface Click {
    fun onClick()
    fun onLongClick() {

    }
}
interface onDraw {

}
open class View {
}

class Button: View(), Click, onDraw{
    var nom2 =""
    companion object {
        val nombre = "dsada"
    }
    override fun onClick() {
        TODO("Not yet implemented")
    }

    override fun onLongClick() {
        super.onLongClick()
    }
}


data class Usuario(var id: Int = 1,
                   var nombre: String = "",
                   var edad: Int = 2,
                   val tipo: TipoUs,
                   val tipo2: String) {

}

val ADMIN = "ADMIN"
val TECNICO = "TECNICO"
val CLIENTE = "CLIENTE"
enum class TipoUs {
    ADMIN,
    TECNICO,
    CLIENTE
}

object Clase1Instancia {
    var nombre: String = ""
    fun mostrar() {

    }
}

fun main() {
    var us = Usuario(1,"Matt", 15, TipoUs.ADMIN, ADMIN)

    var x = when(us.tipo2) {
        ADMIN -> "A"
        CLIENTE -> "C"
        TECNICO -> "T"
        else -> "A"
    }
    var y = when(us.tipo) {
        TipoUs.ADMIN-> "A"
        TipoUs.CLIENTE ->"C"
        TipoUs.TECNICO ->"T"
    }

    Clase1Instancia.nombre
    Clase1Instancia.mostrar()
    Button.nombre
    var b = Button()
    b.nom2
}