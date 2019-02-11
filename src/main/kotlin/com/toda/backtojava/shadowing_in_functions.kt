package com.toda.backtojava

import java.util.*

/**
 * Agree that Variable Shadowing can be confusing for Java developer. But generally this concept is to avoid
 * global variables and developer is notified by IDE that parameter is not used or variable is shadowed.
 * Kotlin define scope where variable name is bound.
 * Moreover:
 *
 * compileKotlin {
 *      kotlinOptions.allWarningsAsErrors = true
 * }
 *
 * or param -Werror can be used  -> warnings are switched to error on compile time
 *
 * 
 * It can be worse:
 * Python:
 *  def inc(num):
 *      num = 2
 *      if num > 0:
 *          num = 3
 *      print num
 *
 *  inc(-1)
 *
 *  prints 3
 *
 *  JS:
 */

fun main() {
    PropertyShadowing(1).inc(5)

    PropertyShadowingSubclass().inc(5)

    shadowingUseCase(" 123aAa ")
}

class PropertyShadowing(private var num: Int) {

    fun inc(num: Int) {

        val num = Random(9).nextInt()

        this.num = num

        if (this.num > 0) {
            val num = 3
        }
        println("num: $num")
    }
}

/**
 * Property hiding
 * For java see: https://dzone.com/articles/variable-shadowing-and-hiding-in-java
 */

class PropertyShadowingSubclass(override var num: Int = -5) : PropertyShadowingSuperclass(num) {

    fun inc(num: Int) {

        val num = Random(8).nextInt()

        this.num = super.num

        if (this.num > 0) {
            val num = 3
        }
        println("num: $num")
    }
}

//sealed
//abstract
open class PropertyShadowingSuperclass(open val num: Int)


fun shadowingUseCase(someUserInput: String): Int {
    val someUserInput = someUserInput.trim().toLowerCase()
    return someUserInput.length
}


