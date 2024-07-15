abstract open class Shiva {
    fun lordShiva() {
        println("Devo ke Dev Mahadev....")
    }
    abstract fun prayer()
}

class Rama : Shiva(){
    override fun prayer() {
        println("Rama's Prayer..")
    }
}

class Krishna : Shiva(){
    override fun prayer() {
        println("Krishna's Prayer..")
    }
}

fun main() {
    var s :  Shiva = Rama()
    s.prayer()
    s.lordShiva()
    var k : Shiva = Krishna()
    k.prayer()
    k.lordShiva()

}