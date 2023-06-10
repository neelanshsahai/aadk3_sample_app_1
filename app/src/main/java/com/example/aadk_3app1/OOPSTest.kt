package com.example.aadk_3app1

// List of to-dos for the students
// TODO 1: Explore about hashCode() method of a class
// TODO 2: Check what are the limitations of a protected method or class
// TODO 3: Check if there are any other access modifiers specifically in Kotlin
// TODO 4: Identify what are `open` keywords used for
// TODO 5: Find out what user interactions trigger what lifecycle components

// Classes and Objects
class A {

}

class B() {

}

class C(var x: Int) {

}

data class D(var y: Int, var z: Float) {

}

class Vehicle(var noOfWheels: Int, var type: String, var company: String, var owner: String?) {

    public fun drive() {
        println("Drive "+ this.company + " " + this.type)
        checkForAnyProblems()
    }

    // 2nd Encapsulation
    private fun checkForAnyProblems() {
        println("There is a problem")
    }

//    override fun equals(other: Any?): Boolean {
//        return this.noOfWheels == (other as Vehicle).noOfWheels
//    }

//    override fun toString(): String {
//        return "String representation of a Vehicle ["+this.noOfWheels+", "+this.company+"]"
//    }
}

// 4th polymorphism - overloading
class Calculator {
    // Method Overloading
    fun add(n1: Int, n2: Int): Int {
        println("called 1st func")
        return n1+n2
    }

    fun add(n1: Int, n2: Int, n3: Int): Int {
        println("called 2nd func")
        return n1+n2+n3
    }

    fun add(n1: Float, n2: Float): Float {
        println("called 3rd func")
        return n1+n2
    }
}


// 4th - Polymorphism - overriding
// Superclass
open class Person() {
    open fun sayHi() {
        println("Hi")
    }
    open fun introduce(name: String) {
        println("Hi, I am $name")
    }
}

// Subclass
class Boy: Person() {
    override fun introduce(name: String) {
        println("Hello, my name is $name")
    }
}

class Girl: Person() {
    override fun sayHi() {
        println("Heya !!!")
    }
}

fun main() {
    val john = Boy()
    val lisa = Girl()

    john.sayHi()
    john.introduce("John")

    lisa.sayHi()
    lisa.introduce("Lisa")


//    val calc = Calculator()
//    val s1 = calc.add(1,2)
//    val s2 = calc.add(1,2,3)
//    val s3 = calc.add(1f,2f)
//    println(s1)
//    println(s2)
//    println(s3)

//    val bike1 = Vehicle(2, "Bike", "Suzuki", "John")
//    val bike2 = Vehicle(3, "Bike", "Yamaha", "Jin")

//    println(bike1) // bike1.toString()
//    println(bike2)

//    if (bike1 == bike2) { // bike1.equals(bike2)
//        println("Objects are the same")
//    } else {
//        println("Objects are different")
//    }

//    bike1.drive()
//    bike1.checkForAnyProblems()

}


/*
// 1st Abstraction
abstract class Calculator() {
    abstract fun add()
    abstract fun multiply()
}
*/

/*
// 3rd Inheritance
class LivingThings(var position: String, var age: Int, var size: String) {
    fun breathe() {}
    fun growOld() {}
    fun provide() {}
}

class Animals: LivingThings {
    fun move() {}
}

class Trees: LivingThings {
    fun giveFruit() {}
}

class Human: Animals {
    var gender: String = ""
    fun applyLogic() {}
}

class Boy: Human {
//    gender = "Male"
}

class Girl: Human {
//    gender = "Female"
}
*/


/*
1st IMP concept in OOPS --> Abstraction
Can be achieved using Abstract classes, abstract functions, or interfaces
*/

// DSA

// SD -> HLD, LLD


/*
* 2nd IMP concept in OOPS --> Encapsulation
* Access Modifier --> public, private, protected, etc (Kotlin)
* Encapsulating an entire functionality within the scope of the class,
* such that it cannot be used outside of that class
* */

/*
* 3rd, and the most important one --> Inheritance
* Parent - Child
* all the properties or attributes or assets are by default accessible by the child
* */

/*
* 4th, Polymorphism - 2 major things
* 1 - Overloading -> same function having different definitions
*                for eg. add with 2 params, add with 3 params, add with different type of params
* 2 - Overriding -> changing the definition of a function
* */
