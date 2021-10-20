package Tasks

object Task_14 {
  def solution(s: String, wordDict: List[String]): List[String] = {
    findWords(s"${s.head}", s.tail, wordDict).map(a => a.mkString(" "))
  }

  def findWords (leftPart: String, rightPart:String, wordDict: List[String]): List[List[String]] = {
    (leftPart, rightPart) match {
      case (l, "") => if (wordDict.contains(l)) List(List(l)) else Nil
      case (l, r) if wordDict.contains(l) =>
        val leftInc = findWords(s"${r.head}", r.tail, wordDict).map(list => l :: list)
        val rightInc = findWords(s"$l${r.head}", r.tail, wordDict)
        leftInc ::: rightInc
      case (l, r) => findWords(s"$l${r.head}", r.tail, wordDict)
    }
  }
}

object sol14 extends App {

  println(s"Task 14 = ${Task_14.solution("catsanddog", List("cat", "cats", "and", "sand", "dog"))}")
  // Task 14 = List(
  //   "cats and dog",
  //   "cat sand dog"
  // )

  println(s"Task 14 = ${Task_14.solution("pineapplepenapple", List("apple", "pen", "applepen", "pine", "pineapple"))}")
  // Task 14 = List(
  //   "pine apple pen apple",
  //   "pineapple pen apple",
  //   "pine applepen apple"
  // )

  println(s"Task 14 = ${Task_14.solution("catsandog", List("cats", "dog", "sand", "and", "cat"))}")
  // Task 14 = List()

  println(s"Task 14 = ${Task_14.solution("abcd", List("a", "abc", "b", "cd"))}")
  // Task 14 = List(a b cd)
}