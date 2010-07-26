// Listing 8.4 Running the DSL Processor

package ch8.trading.validating
package dsl

object Main {

  def main(args: Array[String]) {
    // val str = """settle trades for customer "chase" in "JPN" market of "ibm" internally with us at "a-345""""
    val str = """settle trades for broker "icici" in "JPN" market safekeep security internally with us at "us-123" settle cash externally at "BOJ" "b-954""""

    import SSI_Dsl._

    parseAll(standing_rules, str) match {
      case Success(s, _) => println(s)
      case Failure(msg, _) => println("Failure: " + msg)
      case Error(msg, _) => println("Error: " + msg)
    }
  }
}
