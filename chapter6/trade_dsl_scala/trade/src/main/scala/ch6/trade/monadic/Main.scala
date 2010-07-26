package ch6.trade
package dsl

object Main {
  def main(args: Array[String]): Unit = {
    import TradeImplicits._

    import api._
    import Accounts._
    import Instruments._
    import Markets._
    import Currencies._

    val fixedIncomeTrade1: Trade =
      200 discount_bonds IBM for_client NOMURA on NYSE at 72.ccy(USD)

    val fixedIncomeTrade2: Trade =
      100 discount_bonds IBM for_client NOMURA on HKG at 77.ccy(USD)

    val trades = List(fixedIncomeTrade1, fixedIncomeTrade2)

    import TradeDslM._

    val trds =
      for {
        trade <- trades
        trValidated <- validate(trade)
        trEnriched <- enrich(trValidated)
        trFinal <- journalize(trEnriched)
      }
      yield trFinal
    println(trds)
  }
}

