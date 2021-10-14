def solution3(nums: Array[Int], target: Int): Array[(Int, Int)] = {
  val numsInd = nums.zipWithIndex.groupBy(a => a._1)
    .map(x => (x._1, x._2.map(b => b._2)))

  numsInd.collect {
    case (value, index) if numsInd.contains(target - value) =>
      (index,numsInd(target - value))
  }.toArray
}

Array(2, 7, 2, 11, 15).zipWithIndex.groupBy(a => a._1)
  .map(x => (x._1, x._2.map(b => b._2)))
Array(2, 7, 2, 11, 15).zipWithIndex.map( x => (x._2,x._1)).toMap

  println(s"Task 1 = ${solution3(Array(2, 7, 2, 11, 15), 9).toList}")
  // Task 1 = List(0, 1)

  println(s"Task 1 = ${solution3(Array(3, 2, 4), 6).toList}")
  // Task 1 = List(1, 2)

  println(s"Task 1 = ${solution3(Array(3, 3), 6).toList}")
  // Task 1 = List(0, 1)