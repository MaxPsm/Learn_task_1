package Tasks

import scala.annotation.tailrec

object Task_9 {

  def solution2(s: String, p: String): Boolean = {
    (s, p) match {
      case (s, p) if p.isEmpty => s.isEmpty
      case (s, p) if s.nonEmpty && (s.head == p.head || p.head == '.') =>
        if (p.length > 1 && p.tail.head == '*') solution2(s.tail, p)
        else solution2(s.tail, p.tail)
      case (s, p) if p.length > 1 && p.tail.head == '*' => solution2(s, p.tail.tail)
      case _ => false
    }
  }
}

object sol9 extends App {

  println(s"Task 9 = ${Task_9.solution2("aa", "a")}")
  // Task 9 = false

  println(s"Task 9 = ${Task_9.solution2("aa", "a*")}")
  // Task 9 = true

  println(s"Task 9 = ${Task_9.solution2("ab", ".*")}")
  // Task 9 = true

  println(s"Task 9 = ${Task_9.solution2("aab", "c*a*b")}")
  // Task 9 = true

  println(s"Task 9 = ${Task_9.solution2("mississippi", "mis*is*p*.")}")
  // Task 9 = false
}