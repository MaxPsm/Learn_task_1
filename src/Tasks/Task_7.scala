package Tasks

object Task_7 {
  def solution(nums: Array[Int]): Boolean = {
    val (maxJump, _) = nums
      .zipWithIndex
      .foldLeft((0,0)){
        case ((accJump, accInd), (elemJump,elemInd))
          if accJump < elemInd + elemJump && elemInd <= accInd => (elemInd + elemJump, elemInd + elemJump)
        case ((accJump, accInd), _) => (accJump, accInd)
      }
    maxJump >= nums.length - 1
  }
}

object sol7 extends App {

  println(s"Task 7 = ${Task_7.solution(Array(2, 3, 1, 1, 4))}")
  // Task 7 = true

  println(s"Task 7 = ${Task_7.solution(Array(3, 2, 1, 0, 4))}")
  // Task 7 = false

  println(s"Task 7 = ${Task_7.solution(Array(3, 2, 3, 0, 0, 0))}")
  // Task 7 = true
}
