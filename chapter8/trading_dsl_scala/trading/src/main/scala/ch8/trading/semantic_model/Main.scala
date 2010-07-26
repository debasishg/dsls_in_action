// Listing 8.4 Running the DSL Processor

package ch8.trading.semantic
package dsl

object Main {

  def main(args: Array[String]) {
    val str = """(100 IBM shares to buy at max 45, 40 Sun shares 
      to sell at min 24, 25 CISCO shares to buy at max 56) 
      for account "A1234""""

    import OrderDsl._

    order(new lexical.Scanner(str)) match {
      case Success(order, _) => println(order)
      case Failure(msg, _) => println("Failure: " + msg)
      case Error(msg, _) => println("Error: " + msg)
    }
  }
}
