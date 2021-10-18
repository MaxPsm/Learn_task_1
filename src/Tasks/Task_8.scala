package Tasks

object Task_8 {
  def solution(s: String): Int = {
    val subStrings = s.scanLeft("") {
      (str: String, c: Char) => str.substring(1 + str.indexOf(c)) + c
    }
    subStrings.map(str => str.length).reduce(Math.max)
  }
}

object sol8 extends App {

  println(s"Task 8 = ${Task_8.solution("abcabcbb")}")
  // Task 8 = 3

  println(s"Task 8 = ${Task_8.solution("bbbbb")}")
  // Task 8 = 1

  println(s"Task 8 = ${Task_8.solution("pwwkew")}")
  // Task 8 = 3

  println(s"Task 8 = ${Task_8.solution("")}")
  // Task 8 = 0
}