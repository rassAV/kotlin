abstract class Figure(var x: Float, var y: Float) {
    abstract fun area(): Float
    fun gettingX(): Float = x
    fun gettingY(): Float = y
}