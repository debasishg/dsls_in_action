package ch3.account

object Main {
  def main(args: Array[String]) {
  
    // implciit conversion from Account to AccountDSL
    implicit def enrichAccount(acc: Account): AccountDSL =
      new AccountDSL(acc)
  
    val acc1 = new Account("acc-1", "David P.")
    val acc2 = new Account("acc-2", "John S.")
    val acc3 = new Account("acc-3", "Fried T.")

    acc1 << "Mary R." << "Shawn P." << "John S."
    val accounts = List(acc1, acc2, acc3)
    accounts filter(_ belongsTo "John S.") map(_ getFirstName) foreach(println)
    val threshold = 0f

    // application of Scala higher odrer functions / combinators
    accounts.filter(_ belongsTo "John S.")
            .map(_.calculate(new CalculatorImpl))
            .filter(_ > threshold)
            .foldLeft(0f)(_ + _)

    // implicit value of the Calculator
    implicit val calc = new CalculatorImpl

    accounts.filter(_ belongsTo "John S.")
            .map(_.calculateInterest)
            .filter(_ > threshold)
            .foldLeft(0f)(_ + _)
  }
}
