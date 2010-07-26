// Listing 6.20 DSL for modeling Account Balance

package ch6.trade
package dsl

import java.util.Date
import api._
import Util._
import Currencies._

trait Balances {
  type Balance

  def balance(amount: BigDecimal, ccy: Currency, asOf: Date): Balance
  def inBaseCurrency(b: Balance): (Balance, Currency)
  def getBaseCurrency: Currency = USD

  // ideally it should pick up the factor from a table
  // that maps the currency to the base currency
  def getConversionFactor(c: Currency) = 0.9 //.. stubbed
}

class BalancesImpl extends Balances {
  type Balance = (BigDecimal, Currency, Date)

  override def balance(amount: BigDecimal, ccy: Currency, asOf: Date)
    = (amount, ccy, asOf)

  override def inBaseCurrency(b: Balance)
    = ((b._1 * getConversionFactor(getBaseCurrency), b._2, b._3), getBaseCurrency)
}

object Balances extends BalancesImpl
