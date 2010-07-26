package ch6.trade
package api


trait TaxFeeRules {
  def forTrade(trade: Trade): List[TaxFee]
  def calculatedAs(trade: Trade): PartialFunction[TaxFee, BigDecimal]
}

