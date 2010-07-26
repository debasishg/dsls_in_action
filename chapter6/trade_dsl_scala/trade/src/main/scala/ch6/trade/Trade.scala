// Listing 6.4 Trade model in Scala
package ch6.trade
package api


import java.util.Date

trait Trade {
  def tradingAccount: Account
  def instrument: Instrument
  def currency: Currency
  def tradeDate: Date
  def unitPrice: BigDecimal
  def quantity: BigDecimal
  def market: Market
  def principal = unitPrice * quantity

  var cashValue: BigDecimal = _
  var taxes: Map[TaxFee, BigDecimal] = _
}

trait FixedIncomeTrade extends Trade {
  override def instrument: FixedIncome
  var accruedInterest: BigDecimal = _
}

trait EquityTrade extends Trade {
  override def instrument: Equity
}
