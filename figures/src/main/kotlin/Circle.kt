class Circle(x: Float, y: Float,  private var radius: Float) : Figure(x, y), Movable, Transforming {
    fun getRadius(): Float = radius

    override fun area(): Float = Math.PI.toFloat() * radius * radius

    override fun move(dx: Float, dy: Float) { x += dx; y += dy }

    override fun resize(zoom: Float) { radius *= zoom }

    private fun Float.abs(): Float = if (this < 0) -this else this
    override fun rotate(direction: RotateDirection, centerX: Float, centerY: Float) {
        var modX: Float = x
        var modY: Float = y
        var distX: Float = (x - centerX).abs()
        var distY: Float = (y - centerY).abs()
        if (direction == RotateDirection.Clockwise) {
            if (y >= centerY) {
                modX = centerX + distY
            } else {
                modX = centerX - distY
            }
            if (x >= centerX) {
                modY = centerY - distX
            } else {
                modY = centerY + distX
            }
        } else {
            distX *= -1
            distY *= -1
            if (y >= centerY) {
                modX = centerX + distY
            } else {
                modX = centerX - distY
            }
            if (x >= centerX) {
                modY = centerY - distX
            } else {
                modY = centerY + distX
            }
        }
        x = modX
        y = modY
    }
}