// Listing 6.17 Modeling the trade lifecycle in a DSL

package ch6.trade
package dsl

import api._

trait TradeDsl {
  type T <: Trade

  def withTrade(trade: T)(op: T => Unit): T = {

    validate(trade) match {
      case true =>
        (enrich andThen journalize andThen op)(trade)
      case _ =>
    }
    trade
  }

  def validate(trade: T): Boolean = {
    //.. actual validation logic goes here
    true
  }
  def enrich: PartialFunction[T, T]
  def journalize: PartialFunction[T, T] = {
    case t => t //..actual journalizing logic goes here
  }
}


