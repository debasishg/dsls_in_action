// Listing 4.9 ActivityReport  with specialized implementations of groupBy

package ch4.portfolio.specialized

object ActivityReport {
  type Instrument = String

  case class TradedQuantity(instrument: Instrument, quantity: Int)

  implicit def tuple2ToLineItem(t: (Instrument, Int)) =
    TradedQuantity(t._1, t._2)

  case class ActivityReport(account: String,
    quantities: List[TradedQuantity]) {
    import scala.collection.mutable._

    def groupByInstrument = {
      val m =
        new HashMap[Instrument, Set[TradedQuantity]]
          with MultiMap[Instrument, TradedQuantity]
      for(q <- quantities) 
        m addBinding (q.instrument, q)

      m.keys.toList
            .sortWith(_ < _)
            .map(m.andThen(_.toList))
    }

    def groupByQuantity = {
      val m =
        new HashMap[Int, Set[TradedQuantity]]
          with MultiMap[Int, TradedQuantity]
      for(q <- quantities)
        m addBinding (q.quantity, q)

      m.keys.toList
            .sortWith(_ < _)
            .map(m.andThen(_.toList))
      }
    }
}

