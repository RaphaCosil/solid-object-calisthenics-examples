// Sem o uso do princípio

interface Area{
		fun calculateSquare(side: Double): Double
		fun calculateCircle(radius: Double): Double
}

class SquareArea: Area{
	override fun calculateSquare(side:Double): Double{
			return side*side
		}
		
	override fun calculateCircle(radius: Double): Double{
			throw UnsupportedOperationException("Square cannot calculate Area like a circle")
		}
		
}

// Com o uso do princípio

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