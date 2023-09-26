package Main

import kotlin.math.*

interface MyNumber<T> {
    var a: Double
    var b: Double
    fun add(x: T): T
    fun neg(x: T): T
    fun sub(x: T): T = add(neg(x))
    operator fun plus(x: T): T = add(x)
    operator fun minus(x: T): T = sub(x)
}

// Define the Complex class implementing MyNumber
class Complex(override var a: Double, override var b: Double) : MyNumber<Complex> {
    override fun add(x: Complex): Complex {
        return Complex(this.a+x.a, this.b + x.b)
    }

    override fun neg(x: Complex): Complex {
        return Complex(-x.a, -x.b)
    }

    override fun toString(): String {
        return "$a+${b}i"
    }
}

class Exponent(override var a:Double, override var b: Double):MyNumber<Exponent>{
    override fun add(x: Exponent): Exponent {
        return Exponent(this.a.pow(this.b) + x.a.pow(x.b), 1.0)
    }

    override fun neg(x: Exponent): Exponent {
        return Exponent(-x.a.pow(x.b), 1.0)
    }

    override fun toString(): String {
        return "Exponent($a, $b)"
    }
}

operator fun Complex.plus(x: Exponent): Complex{
    return Complex(this.a+x.a.pow(x.b), this.b)
}

operator fun Exponent.plus(x:Complex): Complex{
    return Complex(this.a.pow(this.b)+x.a, x.b)

}

fun main() {
    val c1 = Complex(4.0, 2.0)
    val c2 = Complex(1.0, 2.0)
    val e1 = Exponent(2.0,3.0)
    val e2 = Exponent(1.0,2.0)

    println("c1 + c2 = ${c1+c2}")
    println("c1 - c2 = ${c1-c2}")
    println("e1 + e2 = ${e1+e2}")
    println("e1 - e2 = ${e1-e2}")
    println("c1 + e1 = ${c1+e1}")
    println("c1 - e1 = ${e1+c1}")
}


