// Listing 6.16 DSL Composition

package ch6.trade
package dsl

object EquityTradeMarketRuleDsl extends MarketRuleDsl {
  val semantics = EquityTradeDsl
}

object FixedIncomeTradeMarketRuleDsl extends MarketRuleDsl {
  val semantics = FixedIncomeTradeDsl
}

object ComposedDsl {
  def main(args: Array[String]): Unit = {
    import TradeImplicits._

    import api._
    import Accounts._
    import Instruments._
    import Markets._
    import Currencies._
    import FixedIncomeTradeMarketRuleDsl._

    val user = "john"

    // Listing 6.18 The Trade Lifecycle DSL

    withTrade(
      200 discount_bonds IBM
        for_client NOMURA
          on NYSE
          at 72.ccy(USD)) {trade =>
            Mailer(user) mail trade
            Logger() log trade
        } cashValue
  }
}
