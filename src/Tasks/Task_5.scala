package Tasks

import scala.annotation.tailrec

@tailrec
object Task_5 {
  def findPower(list: List[Int], acc: List[List[Int]]): List[List[Int]] = {
    list match {
      case Nil => acc
      case a :: b => findPower(b, acc ::: acc.map(x => a :: x))
    }
  }

  def solution(nums: Array[Int]): List[List[Int]] = {
    findPower(nums.toList, Nil :: Nil)
  }
}

object sol5 extends App {
  println(s"Task 5 = ${Task_5.solution(Array(1, 2, 3))}")
}