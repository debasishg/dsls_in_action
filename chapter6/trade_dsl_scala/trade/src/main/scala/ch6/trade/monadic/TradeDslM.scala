// Listing 6.26 Monadic TradeDsl

package ch6.trade
package dsl

import api._
class TradeDslM {
  // in real life application there will be detailed validation
  // of a trade somewhere within the Trade model. Here we stub it
  // with the method isValid
  def validate(trade: Trade): Option[Trade] = isValid(trade) match {
    case true => Some(trade)
    case _ => None
  }
  
  def enrich(trade: Trade): Option[Trade] = Some(trade) //..stubbed
  def journalize(trade: Trade): Option[Trade] = Some(trade) //..stubbed

  // stub
  def isValid(trade: Trade) = true
}

object TradeDslM extends TradeDslM
