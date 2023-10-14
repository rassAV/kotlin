import kotlin.math.abs

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

fun moveRobot(r: Robot, toX: Int, toY: Int) {
    fun move(r: Robot, toAx: Int, lenAx: Int, d1: Direction, d2: Direction) {
        val d: Direction
        if (toAx >= 0) d = d1 else d = d2
        while(r.getDirection() != d.toString()) {
            r.turnRight()
        }
        for (i in 0..abs(lenAx)) {
            r.stepForward()
        }
    }
    move(r, toX - r.x, abs(toX - r.x) - 1, Direction.RIGHT, Direction.LEFT)
    move(r, toY - r.y, abs(toY - r.y) - 1, Direction.UP, Direction.DOWN)
}

fun main() {
    val r = Robot(0, 0, Direction.UP)
    println(r.toString())
    moveRobot(r, 5, 10)
    println(r.toString())
    moveRobot(r, -4, -7)
    println(r.toString())
    moveRobot(r, 20, -3)
    println(r.toString())
}