package ch4.portfolio.generic

object Main {
  def main(args: Array[String]): Unit = {
    import ActivityReport._
    val activityReport =
      ActivityReport("john doe",
        List(("IBM", 1200), ("GOOGLE", 2000), ("GOOGLE", 350), ("VERIZON", 350), ("IBM", 2100), ("GOOGLE", 1200)))

    println(activityReport groupBy(_.instrument))
    println(activityReport groupBy(_.quantity))

  }
}
