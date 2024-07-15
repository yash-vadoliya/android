fun main() {
    print("Enter The Value :")
    var i : Int = readLine()!!.toInt()

    when(i){
        1 -> print("You Enter One..")
        2 -> print("You Enter Two..")
        3,4,5 -> {
            print("You Enter 3, 4 or 5")
            println("Your Value is = $i")
        }
        in(6 .. 10)->{
            print("You Enter Between 6 to 10..")
            println("Your Enter Value is = $i")
        }
        else -> {
            println("Plz, Enter value")
        }
    }

}