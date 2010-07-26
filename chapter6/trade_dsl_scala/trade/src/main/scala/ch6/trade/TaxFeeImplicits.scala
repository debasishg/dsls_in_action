package ch6.trade
package dsl

object TaxFeeImplicits {
  class TaxHelper(factor: Double) {
    def percent_of(c: BigDecimal) = factor * c.doubleValue / 100
  }

  implicit def Double2TaxHelper(d: Double) = new TaxHelper(d)
}
