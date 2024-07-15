fun main() {
    var ar1 = Array<Int>(5){0}
    var ar2 = arrayOf(10,20,30,40,50)
    var ar3 = arrayOf<Int>(10,20,30,40,50)
    var ar4 = arrayOf<String>("Yash","Vadoliya")
    var ar5 = arrayOf(10,20,"Yash",30,40,"Vadoliya",50)

    println(ar1[2])
    println(ar2[1])
    println(ar3[3])
    println(ar4[0])
    println(ar5[3])

    for( el in ar2){
        print("$el  ")
    }

}