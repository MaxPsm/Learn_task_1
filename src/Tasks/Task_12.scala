package Tasks

import scala.util.matching.Regex

object Task_12 {
  def solution(s: String): Boolean = {
    s.trim.matches("[+-]?(\\d+([.]\\d*)?([eE][+-]?\\d+)?|[.]\\d+([eE][+-]?\\d+)?)")
  }
}

object sol12 extends App {

  println(s"Task 12 1 = ${Task_12.solution("0")}")         // 1 Task 12 = true
  println(s"Task 12 2 = ${Task_12.solution(" 0.1 ")}")     // 2 Task 12 = true
  println(s"Task 12 3 = ${Task_12.solution("abc")}")       // 3 Task 12 = false
  println(s"Task 12 4 = ${Task_12.solution("1 a")}")       // 4 Task 12 = false
  println(s"Task 12 5 = ${Task_12.solution("2e10")}")      // 5 Task 12 = true
  println(s"Task 12 6 = ${Task_12.solution(" -90e3   ")}") // 6 Task 12 = true
  println(s"Task 12 7 = ${Task_12.solution(" 1e")}")       // 7 Task 12 = false
  println(s"Task 12 8 = ${Task_12.solution("e3")}")        // 8 Task 12 = false
  println(s"Task 12 9 = ${Task_12.solution(" 6e-1")}")     // 9 Task 12 = true
  println(s"Task 12 10 = ${Task_12.solution(" 99e2.5 ")}")  // 10 Task 12 = false
  println(s"Task 12 11 = ${Task_12.solution("53.5e93")}")   // 11 Task 12 = true
  println(s"Task 12 12 = ${Task_12.solution(" --6 ")}")     // 12 Task 12 = false
  println(s"Task 12 13 = ${Task_12.solution("-+3")}")       // 13 Task 12 = false
  println(s"Task 12 14 = ${Task_12.solution("95a54e53")}")  // 14 Task 12 = false
  println(s"Task 12 15 = ${Task_12.solution(".1")}")        // 15 Task 12 = true
  println(s"Task 12 16 = ${Task_12.solution("4.")}")        // 16 Task 12 = true
  println(s"Task 12 17 = ${Task_12.solution("-.9")}")       // 17 Task 12 = true
  println(s"Task 12 18 = ${Task_12.solution("-90E3")}")     // 18 Task 12 = true
}
