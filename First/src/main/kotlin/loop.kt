fun main() {
    for(i in 1 .. 10)
        print("$i ")

    println()

    for (i in 1 .. 10 step 2)
        print("$i ")

    println()

    for (i in 2 .. 10 step 2)
        print("$i ")

    println()

    for (i in 10 downTo  1)
        print("$i ")

    println()

    for (i in 100 downTo  1 step 5*2)
        print("$i ")
}