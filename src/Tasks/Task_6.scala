package Tasks

import scala.annotation.tailrec

case class ListNode(
                     var x: Int = 0,
                     var next: ListNode = null
                   )

object Task_6 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val dummyHead = ListNode(1)
    addNodes(dummyHead, l1, l2, 0)
    dummyHead.next
  }

@tailrec
  def addNodes(headNode: ListNode, l1: ListNode, l2: ListNode, carry: Int): Unit = {
    (l1, l2) match {
      case (null, null) => {
        if (carry == 1) headNode.next = ListNode(1)
      }
      case _ => {
        val (value1, nextL1) = l1 match {
          case null => (0, null)
          case _ => (l1.x, l1.next)
        }
        val (value2, nextL2) = l2 match {
          case null => (0, null)
          case _ => (l2.x, l2.next)
        }
        val nextNode = ListNode((value1+value2+carry)%10)
        val nextCarry = (value1 + value2 + carry)/10
        headNode.next = nextNode
        addNodes(nextNode, nextL1, nextL2, nextCarry)
      }
    }
  }
}


object sol6 extends App {
  println(s"Task 6 = ${Task_6.addTwoNumbers(ListNode(2, ListNode(4, ListNode(3))), ListNode(5, ListNode(6, ListNode(4))))}")
  // Task 6 = ListNode(7,ListNode(0,ListNode(8,null)))

  println(s"Task 6 = ${Task_6.addTwoNumbers(ListNode(), ListNode())}")
  // Task 6 = ListNode(0, null)

  println(s"Task 6 = ${Task_6.addTwoNumbers(ListNode(9, ListNode(9, ListNode(9, ListNode(9,ListNode(9,ListNode(9, ListNode(9))))))), ListNode(9, ListNode(9, ListNode(9, ListNode(9)))))}")
  // Task 6 = ListNode(8,ListNode(9,ListNode(9,ListNode(9,ListNode(0,ListNode(0,ListNode(0,ListNode(1,null))))))))
}
