package Tasks

object Task_11 {
  def solution(nums: Array[Int]): List[List[Int]] = {
    nums.permutations.map(l => l.toList).toList
  }
}

object sol11 extends App {
  println(s"Task 11 = ${Task_11.solution(Array(1, 2, 3)).mkString("List( \n", ", \n", "\n)")}")
  // Task 11 = List(
  //   List(1, 2, 3),
  //   List(1, 3, 2),
  //   List(2, 1, 3),
  //   List(2, 3, 1),
  //   List(3, 1, 2),
  //   List(3, 2, 1)
  // )
}
