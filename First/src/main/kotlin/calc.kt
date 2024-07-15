
fun main() {

    println("01. Addition")
    println("02. Substraction")
    println("03. Multiplication")
    println("04. division")
    println("05. Exit")

    print("Enter Your Choice")
    var ch = readLine()!!.toInt()

    when (ch)
    {
        1 ->{
            print("Enter Value :")
            var no1 = readLine()!!.toInt()
            print("Enter Value :")
            var no2 = readLine()!!.toInt()
            println("Addition Is : ${no1+no2}")
         }
         2 ->{
             print("Enter Value :")
             var no1 = readLine()!!.toInt()
             print("Enter Value :")
             var no2 = readLine()!!.toInt()
             println("Substraction Is : ${no1-no2}")
         }
         3 ->{
             print("Enter Value :")
             var no1 = readLine()!!.toInt()
             print("Enter Value :")
             var no2 = readLine()!!.toInt()
             println("Multiplication Is : ${no1*no2}")
         }
         4 ->{
             print("Enter Value :")
             var no1 = readLine()!!.toInt()
             print("Enter Value :")
             var no2 = readLine()!!.toInt()
             println("Division Is : ${no1/no2}")
         }
         5 ->{
             println("Thankyou...")
         }
    }
    
    

}

