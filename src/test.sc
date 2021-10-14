import Tasks.Task_4.{binary_find, get_shift}

import scala.annotation.tailrec
//def solution3(nums: Array[Int], target: Int): Array[(Int, Int)] = {
//  val numsInd = nums.zipWithIndex.groupBy(a => a._1)
//    .map(x => (x._1, x._2.map(b => b._2)))
//
//  numsInd.collect {
//    case (value, index) if numsInd.contains(target - value) =>
//      (index,numsInd(target - value))
//  }.toArray
//}

Array(2, 7, 2, 11, 15).zipWithIndex.groupBy(a => a._1)
  .map(x => (x._1, x._2.map(b => b._2)))
Array(2, 7, 2, 11, 15).zipWithIndex.map( x => (x._2,x._1)).toMap

//  println(s"Task 1 = ${solution3(Array(2, 7, 2, 11, 15), 9).toList}")
//  // Task 1 = List(0, 1)
//
//  println(s"Task 1 = ${solution3(Array(3, 2, 4), 6).toList}")
//  // Task 1 = List(1, 2)
//
//  println(s"Task 1 = ${solution3(Array(3, 3), 6).toList}")
//  // Task 1 = List(0, 1)

def toArr (x:Int, l: List[Int]): List[Int] = {
  if (x.abs > 0) toArr(x/10, l :+ x%10) else l
}


//    def rec (list: List[Int]): List[Int] = {
//      list match {
//        case Nil => true
//        case a :: Nil => true
//        case a :: b :: Nil => a == b
//        case a :: b :: c :: Nil => a == c
//        case _ =>
//      }
//    }


object Task2 {
  @tailrec
  def toArr(x: Int, l: List[Int]): List[Int] = {
    if (x.abs > 0) toArr(x / 10, l :+ x % 10) else l
  }

  //    def rec (list: List[Int]): List[Int] = {
  //      list match {
  //        case Nil => true
  //        case a :: Nil => true
  //        case a :: b :: Nil => a == b
  //        case a :: b :: c :: Nil => a == c
  //        case _ =>
  //      }
  //    }

  def solution_t2(x: Int): Boolean = {
    val numList = toArr(x, List())
    val len = numList.length

    val res = for (i <- 0 until len / 2 - 1) yield {
      if (numList(i) != numList(len - i)) false
      else true
    }
    res.contains(false)
  }
}


val b = Task2.toArr(121, List())
b(b.length/2)

for (i <- 0 until b.length / 2) {
  //println(b(i))
  println(b.length - i - 1)
}

println(s"Task 2 = ${Task2.solution_t2(121)}")

val r = "stance sik sik"
r.split(" ").last.length

val nums = Array(4, 5, 6, 7, 0, 1, 2)
val mid = get_shift(nums, 0, nums.length - 1)
val target = 1
nums.length
nums.length - mid

binary_find(nums.slice(mid, nums.length), target, 0, nums.length - mid - 1)

nums.slice(0, mid)
nums.slice(mid, nums.length)