open class Person(name : String)  {
    init {
        println("My name is : $name")
    }
    fun myAdhar(no : Long)
    {
        println("My Adhar : $no")
    }
}

class Teacher(name : String, cName : String) : Person("Mca"){
    init {
        println("My Name Is $name and College name is $cName")
    }
}

fun main(){
    var per1 = Person("Atmiya")
    per1.myAdhar(12345678910)
    var tec = Teacher("Yash","Atmiya")
    tec.myAdhar(12345678911)

}