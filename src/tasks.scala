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
}
