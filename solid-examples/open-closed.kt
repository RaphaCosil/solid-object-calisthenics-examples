// Sem a aplicação do princípio Open/Closed Principle (OCP)

// O método calculateArea calcula a área de diferentes formas (círculo e quadrado) com base em parâmetros passados
// Para serem adicionadas novas formas, o método precisaria ser modificado, isso viola o princípio OCP

class Shape(val type: String, val radius: Double? = null, val side: Double? = null, val base: Double? = null, val height: Double? = null) {
    fun calculateArea(): Double {
        return when (type) {
            "circle" -> Math.PI * (radius ?: 0.0) * (radius ?: 0.0)
            "square" -> (side ?: 0.0) * (side ?: 0.0)
            "triangle" -> 0.5 * (base ?: 0.0) * (height ?: 0.0)
            else -> throw IllegalArgumentException("Forma desconhecida")
        }
    }
}

fun main1() {
    val calculator = ShapeCalculator()

    println("Área do círculo: ${calculator.calculateArea("circle", 5.0, null, null, null)}")
    println("Área do quadrado: ${calculator.calculateArea("square", null, 4.0, null, null)}")
    println("Área do triângulo: ${calculator.calculateArea("triangle", null, null, 6.0, 3.0)}")
}

// Com a aplicação do princípio

// O método calculateArea agora é uma função abstrata na interface Shape, e cada forma (círculo, quadrado, triângulo) implementa sua própria lógica de cálculo de área 
// Isso permite que novas formas sejam adicionadas sem modificar o código existente

interface Shape {
    fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shape {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Square(private val side: Double) : Shape {
    override fun calculateArea(): Double {
        return side * side
    }
}

class Triangle(private val base: Double, private val height: Double) : Shape {
    override fun calculateArea(): Double {
        return 0.5 * base * height
    }
}

fun main2() {
    val circle = Circle(5.0)
    val square = Square(4.0)
    val triangle = Triangle(6.0, 3.0)

    println("Área do círculo: ${circle.calculateArea()}")
    println("Área do quadrado: ${square.calculateArea()}")
    println("Área do triângulo: ${triangle.calculateArea()}")
}

fun main() {
    println("Sem OCP:")
    main1()
    println("\nCom OCP:")
    main2()
}
