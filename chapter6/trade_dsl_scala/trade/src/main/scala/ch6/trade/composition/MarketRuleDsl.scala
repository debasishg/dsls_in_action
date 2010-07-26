// Listing 6.15 A new semantics for TradeDsl – another business rule
package ch6.trade
package dsl

import api._
import Markets._

trait MarketRuleDsl extends TradeDsl {
  val semantics: TradeDsl
  type T = semantics.T

  override def enrich: PartialFunction[T, T] = {
    case t =>
      val tr = semantics.enrich(t)
      tr match {
        case x if x.market == NYSE && x.principal > 1000 =>
          tr.cashValue = tr.cashValue - tr.principal * 0.1
          tr
        case x => x
      }
  }
}