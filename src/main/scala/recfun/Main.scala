package recfun

import scala.annotation.tailrec

/**
  * https://www.coursera.org/learn/progfun1/programming/Ey6Jf/recursion
  * Assignment - Week 1 - Functional Programming Principles
  */

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def getCount(char: Char): Int = char match {
      case '(' => 1
      case ')' => -1
      case _ => 0
    }

    def checkCount(count: Int): Boolean = count == 0

    @tailrec
    def balanceIterator(count: Int, tmpChars: List[Char]): Boolean = {
      if (count < 0) false
      else if (tmpChars.isEmpty) checkCount(count)
      else balanceIterator(getCount(tmpChars.head) + count, tmpChars.tail)
    }

    balanceIterator(0, chars)
  }

  /**
    * Exercise 3
    * How to make it tail recursive - Discussion
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty) 0
    else if (money - coins.head < 0) countChange(money, coins.tail)
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
