// Listing 6.10 Base class for TradingService in Scala

package ch6.trade
package api

import dsl.TaxFeeRulesComponent

trait TradingService
  extends TaxFeeCalculationComponent
  with TaxFeeRulesComponent {

  type T <: Trade

  def taxes(trade: T) =
    taxFeeCalculator.calculateTaxFee(trade)

  def totalTaxFee(trade: T): BigDecimal = {
    taxes(trade).foldLeft(BigDecimal(0))(_ + _._2)
  }

  def cashValue(trade: T): BigDecimal
}

// Listing 6.11  Trading Service for Equity Trades in Scala
object EquityTradingService
  extends TradingService {

  type T = EquityTrade

  val taxFeeCalculator = new TaxFeeCalculatorImpl
  val taxFeeRules = new TaxFeeRulesImpl

  override def cashValue(trade: T): BigDecimal = {
    trade.principal + totalTaxFee(trade)
  }
}

// Listing 6.12 Trading Service for Fixed Income Trades in Scala
object FixedIncomeTradingService
  extends TradingService with AccruedInterestCalculationComponent {

  type T = FixedIncomeTrade

  val taxFeeCalculator = new TaxFeeCalculatorImpl
  val accruedInterestCalculator = new AccruedInterestCalculatorImpl
  val taxFeeRules = new TaxFeeRulesImpl

  def accruedInterest(trade: T): BigDecimal = {
    accruedInterestCalculator.calculateAccruedInterest(trade)
  }

  override def cashValue(trade: T): BigDecimal = {
    trade.principal + accruedInterest(trade) + totalTaxFee(trade)
  }
}

