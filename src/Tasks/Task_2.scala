package Tasks

import scala.annotation.tailrec

object Task2 {
  @tailrec
  def toArr(x: Int, l: List[Int]): List[Int] = {
    if (x.abs > 0) toArr(x / 10, l :+ x % 10) else l
  }


  def solution_t2(x: Int): Boolean = {
    if (x < 0) {
      false
    } else {
      val numList = toArr(x, List())
      val len = numList.length

      val res = for (i <- 0 until len / 2) yield {
        if (numList(i) != numList(len - i - 1)) false
        else true
      }
      !res.contains(false)
    }
  }
}

object sol2 extends App {

  println(s"Task 2 = ${Task2.solution_t2(121)}")
  // Task 2 = true

  println(s"Task 2 = ${Task2.solution_t2(-121)}")
  // Task 2 = false

  println(s"Task 2 = ${Task2.solution_t2(10)}")
  // Task 2 = false

  println(s"Task 2 = ${Task2.solution_t2(-101)}")
  // Task 2 = false

  println(s"Task 2 = ${Task2.solution_t2(0)}")
}