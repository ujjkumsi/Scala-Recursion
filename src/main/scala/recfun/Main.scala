package recfun

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
      if(c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
  
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

      def balanceIterator(count: Int, tmpChars: List[Char]): Boolean = {
        if(tmpChars.isEmpty) checkCount(count)
        else balanceIterator(getCount(tmpChars.head) + count, tmpChars.tail)
      }

      balanceIterator(0,chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
