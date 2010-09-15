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
  case class BalanceRep(amount: BigDecimal, ccy: Currency, asOfDate: Date)
  type Balance = BalanceRep

  override def balance(amount: BigDecimal, ccy: Currency, asOf: Date)
    = BalanceRep(amount, ccy, asOf)

  override def inBaseCurrency(b: Balance)
    = (BalanceRep(b.amount * getConversionFactor(getBaseCurrency), b.ccy, b.asOfDate), getBaseCurrency)
}

object Balances extends BalancesImpl
