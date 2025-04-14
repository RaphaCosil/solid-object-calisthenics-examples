// Sem o uso do princípio Dependency Inversion Principle (DIP)

// O método sum e subtract da classe Calculator dependem diretamente da implementação da classe MathOperations
// Isso significa que, se a implementação da classe MathOperations mudar, a classe Calculator também precisará ser alterada

class BasicMath {
    fun add(x: Double, y: Double): Double {
        return x + y
    }

    fun subtract(x: Double, y: Double): Double {
        return x - y
    }
}

class SimpleCalculator(private val math: BasicMath) {
    fun add(x: Double, y: Double): Double {
        return math.add(x, y)
    }

    fun subtract(x: Double, y: Double): Double {
        return math.subtract(x, y)
    }
}

fun main1() {
    val basicMath = BasicMath()
    val calculator = SimpleCalculator(basicMath)

    println("Soma: ${calculator.add(10.0, 5.0)}")
    println("Subtração: ${calculator.subtract(10.0, 5.0)}")
}

// Com o uso do princípio Dependency Inversion Principle (DIP)

// A classe MathOperations agora é uma interface, e a classe Calculator depende da abstração (interface) em vez de depender diretamente da implementação

interface MathOperations {
    fun add(x: Double, y: Double): Double
    fun subtract(x: Double, y: Double): Double
}

class BasicMathImpl : MathOperations {
    override fun add(x: Double, y: Double): Double {
        return x + y
    }

    override fun subtract(x: Double, y: Double): Double {
        return x - y
    }
}

class AdvancedCalculator(private val math: MathOperations) {
    fun add(x: Double, y: Double): Double {
        return math.add(x, y)
    }

    fun subtract(x: Double, y: Double): Double {
        return math.subtract(x, y)
    }
}

fun main2() {
    val basicMath = BasicMathImpl()
    val calculator = AdvancedCalculator(basicMath)

    println("Soma: ${calculator.add(10.0, 5.0)}")
    println("Subtração: ${calculator.subtract(10.0, 5.0)}")
}

fun main() {
    println("Sem DIP:")
    main1()

    println("\nCom DIP:")
    main2()
}