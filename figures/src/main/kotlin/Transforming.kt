interface Transforming {
    fun resize(zoom: Float)

    fun rotate(direction: RotateDirection = RotateDirection.Clockwise, centerX: Float = 0f, centerY: Float = 0f)
}

enum class RotateDirection {
    Clockwise,
    CounterClockwise
}