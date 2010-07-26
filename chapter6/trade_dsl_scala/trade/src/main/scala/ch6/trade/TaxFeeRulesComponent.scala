// Listing 6.9 DSL for tax fee calculation rules

package ch6.trade
package dsl

import api._
import Markets._

trait TaxFeeRulesComponent {
  val taxFeeRules: TaxFeeRules

  class TaxFeeRulesImpl extends TaxFeeRules {
    override def forTrade(trade: Trade): List[TaxFee] = {
      (forHKG orElse
         forSGP orElse
           forAll)(trade.market)
    }

    val forHKG: PartialFunction[Market, List[TaxFee]] = {
      case HKG =>
        List(TradeTax, Commission, Surcharge)
    }

    val forSGP: PartialFunction[Market, List[TaxFee]] = {
      case SGP =>
        List(TradeTax, Commission, Surcharge, VAT)
    }

    val forAll: PartialFunction[Market, List[TaxFee]] = {
      case _ => List(TradeTax, Commission)
    }

    import TaxFeeImplicits._
    override def calculatedAs(trade: Trade):
        PartialFunction[TaxFee, BigDecimal] = {
      case TradeTax   => 5.  percent_of trade.principal
      case Commission => 20. percent_of trade.principal
      case Surcharge  => 7.  percent_of trade.principal
      case VAT        => 7.  percent_of trade.principal
    }
  }
}

