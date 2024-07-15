fun main() {
    var notnull : String = "This Varible Never Accept Null Value.."
//    notnull = null

    var nullable : String ?= "This Varible Accept Null Value.."
    nullable = null

    nullable = "Hello"

    var inferrednotnull = "The Compiler Assume Not Null Variable.."

    println( StrLength(notnull) )
    println( StrLength(nullable))
}

fun StrLength(nonull : String?): Int?{
    return nonull?.length
}