package com.toda.backtojava

/**
 *  platform type T! means "T or T?"
 *  
 *  Annotations to java - kotlin can recognize null/not null (https://kotlinlang.org/docs/reference/java-interop.html#nullability-annotations)
 *
 *  Solution: https://medium.com/@preslavrachev/platform-types-in-kotlin-5caceeb556ad
 *
 * var result = someJavaApi.doSomething() // returns SomeType!
 * result?.let { someKotlinApi.doSomething(it) } // someKotlinApi.doSomething expects SomeType
 *
 * - where let will be called only in case that result will be not null
 *
 */

fun doSth(text: String?) {
    val f = Utils.format(text)

    println("f.len : ${f?.length}")
}

fun doSthSafe(text: String) {
    val f = Utils.formatSafe(text)

    println("f.len safe : ${f?.length}")
}

fun doNothingOnNull(text: String?) {
    val f = Utils.format(text)

    f?.let { println("f.len avoid : ${f.length}") }
}

fun main() {
    doSth("")
    doSth("something")

    doSthSafe("")
    doSthSafe("something safe")

    doNothingOnNull("")
    doNothingOnNull("something nothing")
}