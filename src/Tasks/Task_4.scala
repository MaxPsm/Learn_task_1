package Tasks

object Task_4 {

  def get_shift(nums:Array[Int], low:Int, high:Int): Int = {
    if (high - low > 1) {
      val mid = (high+low)/2
      if (nums(mid) < nums(0)) get_shift(nums, low, mid) else get_shift(nums, mid, high)
    } else high
  }

  def binary_find(nums:Array[Int], target: Int, start: Int, end: Int): Int = {
    if (start > end) -1
    else {
      val mid = start + (end - start) / 2
      if (nums(mid) == target) mid else
        if(nums(mid) > target) binary_find(nums, target, start, mid - 1) else
          binary_find(nums, target, mid+1, end)
    }
  }

  def solution(nums: Array[Int], target: Int): Int = {
    if (nums(nums.length - 1) > nums(0)){
      binary_find(nums, target, 0, nums.length - 1)
    } else {
      val mid = get_shift(nums, 0, nums.length - 1)
      if (target > nums.last) binary_find(nums.slice(0, mid), target, 0, mid) else
              binary_find(nums.slice(mid, nums.length), target, 0, nums.length - mid - 1) + mid
    }

  }

//  def solution2(nums: Array[Int], target: Int): Int = {
//    if (nums(nums.length - 1) > nums(0)){
//      binary_find(nums, target, 0, nums.length - 1)
//    } else {
//      val mid = get_shift(nums, 0, nums.length - 1)
//      val splitNumbs = nums.splitAt(mid)
//            if (target > splitNumbs._2.last) binary_find(splitNumbs._1, target, 0, mid) else
//              binary_find(splitNumbs._2, target, 0, nums.length - mid) + mid
//    }
//  }

}

object sol4 extends App {
  println(s"Task 4 = ${Task_4.solution(Array(4, 5, 6, 7, 0, 1, 2), 0)}")

  println(s"Task 4 = ${Task_4.solution(Array(4, 5, 6, 7, 0, 1, 2), 3)}")

  println(s"Task 4 = ${Task_4.solution(Array(4, 5, 6, 7, 0, 1, 2), 2)}")

  println(s"Task 4 = ${Task_4.solution(Array(1), 0)}")
}