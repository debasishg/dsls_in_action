// Listing 4.10 Generic Implementation of groupBy

package ch4.portfolio.generic

object ActivityReport {
  type Instrument = String

  case class TradedQuantity(instrument: Instrument, quantity: Int)

  implicit def tuple2ToLineItem(t: (Instrument, Int)) =
    TradedQuantity(t._1, t._2)

  case class ActivityReport(account: String, quantities: List[TradedQuantity]) {
    import scala.collection.mutable._

    def groupBy[T <% Ordered[T]](f: TradedQuantity => T) = {
      val m =
        new HashMap[T, Set[TradedQuantity]]
          with MultiMap[T, TradedQuantity]
      for(q <- quantities)
        m addBinding (f(q), q)
      m.keys.toList.sortWith(_ < _).map(m.andThen(_.toList))
    }
  }
}
