// Listing 6.5 FixedIncomeTrade Implementation and Instantiation
package ch6.trade
package api


import java.util.Date
import Util._

case class FixedIncomeTradeImpl(
  val tradingAccount: Account,
  val instrument: FixedIncome,
  val currency: Currency,
  val tradeDate: Date = TODAY,
  val market: Market,
  val quantity: BigDecimal,
  val unitPrice: BigDecimal) extends FixedIncomeTrade

case class EquityTradeImpl(
  val tradingAccount: Account,
  val instrument: Equity,
  val currency: Currency,
  val tradeDate: Date = TODAY,
  val market: Market,
  val quantity: BigDecimal,
  val unitPrice: BigDecimal) extends EquityTrade
