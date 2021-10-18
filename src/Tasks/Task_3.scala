package Tasks

object Task_3 {
  def solution(s :String): Int = {
    val trimString = s.trim
    if (trimString.nonEmpty) {
      trimString.length - trimString.lastIndexOf(" ") - 1
    } else 0
  }
}

object sol3 extends App{
  println(s"Task 3 = ${Task_3.solution("Hello World")}")
  // Task 3 = 5
  println(s"Task 3 = ${Task_3.solution("World")}")
  // Task 3 = 5
  println(s"Task 3 = ${Task_3.solution("")}")
  // Task 3 = 0
  println(s"Task 3 = ${Task_3.solution("  d")}")
  // Task 3 = 1
}
