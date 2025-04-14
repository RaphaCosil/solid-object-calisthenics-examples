// Sem o uso do princípio Liskov Substitution Principle (LSP)

// A classe SquareArea implementa a interface Area, que define métodos para calcular a área de um quadrado e de um círculo
// Como a classe SquareArea não pode calcular a área de um círculo, ela lança uma exceção UnsupportedOperationException podendo afetar o comportamento do código que utiliza essa classe

interface Area{
		fun calculateSquare(side: Double): Double
		fun calculateCircle(radius: Double): Double
}

class SquareArea: Area{
	override fun calculateSquare(side:Double): Double{
			return side*side
		}
		
	override fun calculateCircle(radius: Double): Double{
			throw UnsupportedOperationException(
				"Square cannot calculate Area like a circle"
				)
		}
		
}

fun main1() {
    val squareArea = SquareArea()
    println("Área do quadrado: ${squareArea.calculateSquare(4.0)}")

    try {
        println("Área do círculo: ${squareArea.calculateCircle(5.0)}")
    } catch (e: UnsupportedOperationException) {
        println("Erro: ${e.message}")
    }
}


// Com o uso do princípio Liskov Substitution Principle (LSP)

// A interface Area foi dividida em duas interfaces: SquareArea e CircleArea
// Isso permite que o código que utiliza essas classes funcione corretamente sem precisar se preocupar com exceções indesejadas

interface SquareArea{
		fun calculateSquare(side: Double): Double
}

interface CircleArea{
		fun calculateCircle(radius: Double): Double
}

class SquareAreaImpl: SquareArea{
	override fun calculateSquare(side:Double): Double{
			return side*side
		}	
}

class CircleAreaImpl: CircleArea{
	override fun calculateCircle(radius: Double): Double{
			return 3.14*(radius*radius)
		}	
}

fun main2() {
    val squareArea = SquareAreaImpl()
    val circleArea = CircleAreaImpl()

    println("Área do quadrado: ${squareArea.calculateSquare(4.0)}")
    println("Área do círculo: ${circleArea.calculateCircle(5.0)}")
}

fun main() {
    println("Sem LSP:")
    main1()

    println("\nCom LSP:")
    main2()
}
