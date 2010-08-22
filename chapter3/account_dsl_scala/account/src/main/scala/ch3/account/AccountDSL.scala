// Listing 3.5 Account DSL in Scala

package ch3.account

/**
 * The Scala class that takes the Java core abstraction as input and adds 
 * new methods on top of it.
 * <p/>
 * The implicit conversion method in the <tt>Main</tt> class makes <tt>AccountDSL</tt>
 * interchangeably usable with the <tt>Account</tt> class.
 */
class AccountDSL(value: Account) {

  import scala.collection.JavaConversions._
  def names =
    value.getNames.toSeq.toList ::: List(value.getFirstName)

  def belongsTo(name: String) = {
    (name == value.getFirstName) || (names exists(_ == name))
  }

  def <<(name: String) = {
    value.addName(name)
    this
  }
  
  def calculateInterest(implicit calc: Calculator): Double = {
    // note that the Calculator is an implicit parameter, which
    // means that the compiler will automatically look for an instance,
    // if available within the lexical scope
    value.calculate(calc)
  }

}

