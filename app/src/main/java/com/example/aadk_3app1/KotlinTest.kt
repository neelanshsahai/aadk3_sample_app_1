package com.example.aadk_3app1

fun main() {
/*
    var testString = "Hello" // Mutable
    val testNumber = 25      // Immutable
*/

    // Mutability -> ability to update
//    testString = "Hey" // This works fine
//    testNumber = 50

    // Data Types in Kotlin
    // Int, Float, Double, Short, Boolean
//    var a: Int = 10
//    var b: Float = 1.5f
//    var c: Double = 1.5
//    var d: Boolean = true
//
//    // What is the difference bw char and string
//    var e: String = "Hello"
//
//    var f: Any = 5
//    f = true
//    f = "New String"
//    f = 1.5f
//

//
//    // named parameters
//    val currentTime = Time(period = AM, minutes = 36, hours = 11, seconds = 48)
//
//    currentTime.period = Period.PM
//    currentTime.hours = 10
//
//    val currentTime1 = Time(11, 48,36, AM)
//    println(currentTime)
//

    // Null Safety
//    var name: String? = null
//    name = "N"
//    name = null
//
//    // Conditions
//    var x = if (name != null) {
//        5
//    } else {
//        10
//    }

//    println(name?.length) // Safe Call
//    println(name ?: "No name given")
//    println(name != null ? name : "No name given")

    var i = 0
    while (i<10) {
        println(i++)
    }
//    for (i in 10 downTo  1 step 2) { // [1, 10]
//        println(i)
//    }

//    for (j in 1..10) { // [1, 10]
//        println(j)
//    }

//    val i: Any = true
//
//    when (i) {
//        1 -> print("One")
//        2 -> print("Two")
//        5 -> print("Five")
//        "xyz" -> print("String")
//        else -> print("nothing")
//    }
//

    val a = 6
    val b = 7
    print(myFunctionAdd(a,b))

}

fun myFunctionAdd(n1: Int, n2: Int): Int {
    return n1 + n2
}


// Time - hours, min, sec, AM/PM
data class Time(
    var hours: Int,
    var minutes: Int,
    var seconds: Int,
    var period: Period
)

enum class Period {
    AM,
    PM
}


// TODO: Discuss about Data Classes vs Normal Classes
