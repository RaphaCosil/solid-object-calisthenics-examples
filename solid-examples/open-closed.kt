// Sem a aplicação do princípio

class Shape {
    fun calculateArea(type: String, radius: Double?, side: Double?): Double {
        return when (type) {
            "circle" -> Math.PI * radius * radius
            "square" -> side * side
            else -> 0.0
        }
    }
}

// Com a aplicação do princípio

interface Shape {
   fun calculateArea(): Double
}

class Circle() : Shape {
    override fun calculateArea(radius: Double): Double {
        return Math.PI * radius * radius
    }
}

class Square() : Shape {
    override fun calculateArea(side: Double): Double {
        return side * side
    }
}

class Triangle() : Shape {
    override fun calculateArea(base: Double, height: Double): Double {
        return 0.5 * base * height
    }
}
