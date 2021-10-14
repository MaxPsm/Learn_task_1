import scala.annotation.tailrec

class tasks {
  object Task1 {
    def solution1(nums: Array[Int], target: Int): Array[(Int, Int)] = {
      val s = for (
        i <- 0 until nums.length - 1;
        j <- i + 1 until nums.length
      ) yield {
        val sum = nums(i) + nums(j)
        val index = if (sum == target) {
          Some(i, j)
        } else None
        index
      }

      s.collect {
        case Some(value) => value
      }.toArray
    }

    //    def solution2(nums: Array[Int], target: Int): Array[(Int, Int)] = {
    //      val numsInd = nums.zipWithIndex.toMap.map(_.swap)
    //
    //      numsInd.collect {
    //        case (index, value)  =>
    //          val b = numsInd.find(_._2 == target - value)
    //          (index,b.get._1)
    //      }.toArray
    //    }
  }


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

  object Task_3 {
    def solution(s: String): Int = {
      val splitString = s.split(" ")
      if (splitString.nonEmpty) {
        splitString.last.length
      } else 0
    }
  }

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

}
  object sol extends App {
    val a = new tasks
    println(s"Task 1 = ${a.Task1.solution1(Array(2, 7, 2, 11, 15), 9).toList}")
    // Task 1 = List(0, 1)

    println(s"Task 1 = ${a.Task1.solution1(Array(3, 2, 4), 6).toList}")
    // Task 1 = List(1, 2)

    println(s"Task 1 = ${a.Task1.solution1(Array(3, 3), 6).toList}")
    // Task 1 = List(0, 1)

    println(s"Task 2 = ${a.Task2.solution_t2(121)}")
    // Task 2 = true

    println(s"Task 2 = ${a.Task2.solution_t2(-121)}")
    // Task 2 = false

    println(s"Task 2 = ${a.Task2.solution_t2(10)}")
    // Task 2 = false

    println(s"Task 2 = ${a.Task2.solution_t2(-101)}")
    // Task 2 = false

    println(s"Task 2 = ${a.Task2.solution_t2(0)}")

    println(s"Task 3 = ${a.Task_3.solution("Hello World")}")
    // Task 3 = 5
    println(s"Task 3 = ${a.Task_3.solution("World")}")
    // Task 3 = 5
    println(s"Task 3 = ${a.Task_3.solution("")}")
    // Task 3 = 5

    println(s"Task 4 = ${a.Task_4.solution(Array(4, 5, 6, 7, 0, 1, 2), 0)}")

    println(s"Task 4 = ${a.Task_4.solution(Array(4, 5, 6, 7, 0, 1, 2), 3)}")

    println(s"Task 4 = ${a.Task_4.solution(Array(4, 5, 6, 7, 0, 1, 2), 2)}")

    println(s"Task 4 = ${a.Task_4.solution(Array(1), 0)}")
}
