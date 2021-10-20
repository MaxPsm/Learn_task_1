package Tasks

object Task_15 {
  def solution(grid: Array[Array[Char]]): Int = {
    val count = 0
    val res = for {
      i <- grid.indices
      j <- grid(0).indices if grid(i)(j) == '1'
    } yield {
      isolateIsland(grid, i, j)
    }
    res.length
  }

  def isolateIsland(g: Array[Array[Char]], x: Int, y: Int): Unit = {
    val outOfBounds = x < 0 || x >= g.length || y < 0 || y >= g(0).length || g(x)(y) == '0'
    if (!outOfBounds) {
      g(x)(y) = '0'
      isolateIsland(g, x - 1, y)
      isolateIsland(g, x, y - 1)
      isolateIsland(g, x + 1, y)
      isolateIsland(g, x, y + 1)
    }
  }
}

object sol15 extends App {
  val grid1 = Array(
    Array('1','1','1','1','0'),
    Array('1','1','0','1','0'),
    Array('1','1','0','0','0'),
    Array('0','0','0','0','0')
  )

  println(s"Task 15 = ${Task_15.solution(grid1)}")
  // Task 15 = 1

  val grid2 = Array(
    Array('1','1','0','0','0'),
    Array('1','1','0','0','0'),
    Array('0','0','1','0','0'),
    Array('0','0','0','1','1')
  )

  println(s"Task 15 = ${Task_15.solution(grid2)}")
  // Task 15 = 3
}