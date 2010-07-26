// Listing 6.8 Tax Fee Calculation Components in Scala

package ch6.trade
package api

sealed abstract class TaxFee(id: String)
case object TradeTax extends TaxFee("Trade Tax")
case object Commission extends TaxFee("Commission")
case object Surcharge extends TaxFee("Surcharge")
case object VAT extends TaxFee("VAT")

trait TaxFeeCalculator {
  def calculateTaxFee(trade: Trade): Map[TaxFee, BigDecimal]
}

import dsl.TaxFeeRulesComponent

trait TaxFeeCalculationComponent { this: TaxFeeRulesComponent =>
  val taxFeeCalculator: TaxFeeCalculator

  class TaxFeeCalculatorImpl extends TaxFeeCalculator {
    def calculateTaxFee(trade: Trade): Map[TaxFee, BigDecimal] = {
      import taxFeeRules._
      val taxfees =
        forTrade(trade) map {taxfee =>
          (taxfee, calculatedAs(trade)(taxfee))
        }
      Map(taxfees: _*)
    }
  }
}

trait AccruedInterestCalculator {
  def calculateAccruedInterest(trade: FixedIncomeTrade): BigDecimal
}

trait AccruedInterestCalculationComponent {
  val accruedInterestCalculator: AccruedInterestCalculator

  class AccruedInterestCalculatorImpl extends AccruedInterestCalculator {
    override def calculateAccruedInterest(trade: FixedIncomeTrade): BigDecimal = {
      //.. will contain detailed domain logc
      //.. stubbed here
      // BigDecimal.valueOf("100")
      100
    }
  }
 
}

