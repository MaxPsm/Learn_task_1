package Tasks

object Task13 {

  def solution(s: String): List[String] = {
    buildIPs(List.empty[String], s, Set.empty[String]).toList
  }

  def buildIPs(validIPs: List[String], str: String, res: Set[String]) : Set[String] = {

    (validIPs.size, str) match {
      case (4, "") => res + validIPs.mkString(".")
      case (4, r) if r.nonEmpty => res
      case (ips, "") if ips < 4 => res
      case _ =>
        (1 to (3 min str.length))
          .map(str.take)
          .filter(isValidIP)
          .map(ip => buildIPs(validIPs :+ ip, str.drop(ip.length), res))
          .reduce(_ union _)
    }
  }

  def isValidIP(str: String) : Boolean = {
    !(str.isEmpty || str.length > 3 || str != "0" && str.startsWith("0") || str.toInt < 0 || str.toInt > 255)
  }
}

object sol13 extends App {
  println(s"Task 13 = ${Task13.solution("25525511135")}")
  // Task 13 = List("255.255.11.135", "255.255.111.35")

  println(s"Task 13 = ${Task13.solution("0000")}")
  // Task 13 = List("0.0.0.0")

  println(s"Task 13 = ${Task13.solution("1111")}")
  // Task 13 = List("1.1.1.1")

  println(s"Task 13 = ${Task13.solution("010010")}")
  // Task 13 = List("0.10.0.10", "0.100.1.0")

  println(s"Task 13 = ${Task13.solution("101023")}")
  // Task 13 = List("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")

  println(s"Task 13 = ${Task13.solution("2552551113500001111010010101023")}")
  // Task 13 = List()
}