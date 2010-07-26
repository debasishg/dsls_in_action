// Listing 8.5 Semantic Model for Order Processing

package ch8.trading.semantic
package dsl

object AST {
  trait PriceType
  case object MIN extends PriceType
  case object MAX extends PriceType

  case class PriceSpec(pt: Option[PriceType], price: Int)

  case class SecuritySpec(qty: Int, security: String) 

  trait BuySell
  case object BUY extends BuySell
  case object SELL extends BuySell

  case class LineItem(ss: SecuritySpec, 
    bs: BuySell, ps: PriceSpec) 

  case class Items(lis: Seq[LineItem])

  case class AccountSpec(account: String) 

  case class Order(items: Items, as: AccountSpec) 
}
