package ch6.trade
package dsl

object ClientPortfolioAuditing extends Auditing {
  val semantics = ClientPortfolio
  val bal: semantics.bal.type = semantics.bal
}
