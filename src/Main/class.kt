package Main

class House {
    val color: String = "white"
    val numberOfWindows: Int = 2
    val isForSale: Boolean = false
    init{
        println("init-1")
    }
    init{
        println("init-2")
    }
}

class Circle(val radius:Double) {
    constructor(name:String) : this(1.0)
    constructor(diameter:Int) : this(diameter / 2.0) {
        println("in diameter constructor")
    }
    init {
        println("Area: ${Math.PI * radius * radius}")
    }
}

fun main(){
    val myHouse = House()
    println(myHouse)
    val c= Circle(3) //class 내 출력 순서에 유의
}