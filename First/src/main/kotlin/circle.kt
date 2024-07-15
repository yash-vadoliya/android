fun main()
{
    var pi = 3.14f
//    var r  : Float? = readLine()

    print("Enter Value Of Redius : ")
    var red : Float? = readLine()?.toFloatOrNull()

    if (red != null)
        println("Area of Circle = ${pi*(red!!*red!!)}")
    else
        println("Invalid Input..")
}