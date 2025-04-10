// Sem o uso do princípio

class MathOperations(){
	fun sum(x: Double, y: Double): Double{
		return x+y
	}
	fun subtract(x: Double, y: Double): Double{
		x-y
	}
}

class Calculator(
	mathOperations: MathOperations
){
	fun sum(x: Double, y: Double): Double{
			return mathOperations.sum(x, y)
	}
	fun subtract(x: Double, y: Double): Double{
			return mathOperations.subtract(x, y)
	}
}

// Com o uso do princípio

class MathOperations(){
	fun sum(x: Double, y: Double): Double
	fun subtract(x: Double, y: Double): Double
}

class MathOperationsImpl(): MathOperations{
	fun sum(x: Double, y: Double): Double{
		return x+y
	}
	fun subtract(x: Double, y: Double): Double{
		x-y
	}
}

class Calculator(
	mathOperations: MathOperations
){
	fun sum(x: Double, y: Double): Double{
			return mathOperations.sum(x, y)
	}
	fun subtract(x: Double, y: Double): Double{
			return mathOperations.subtract(x, y)
	}
}

val calculator = Calculator(MathOperationsImpl())