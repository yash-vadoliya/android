interface  myInterface {
    val no : Int
    fun foo() : String
    fun method(){
        println("This is An Interface pro.")
    }
}

class interfaceimpl : myInterface{
    override val no = 1000
    override fun foo() = "Yash Vadoliya"
}

fun main() {
    var imp = interfaceimpl()
    println(imp.foo())
    println("Number : ${imp.no}")
    imp.method()
}