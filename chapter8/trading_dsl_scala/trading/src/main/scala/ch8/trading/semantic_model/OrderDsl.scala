// Listing 8.6 AST for Order Processing DSL

package ch8.trading.semantic
package dsl

import scala.util.parsing.combinator._
import scala.util.parsing.combinator.syntactical._

object OrderDsl extends StandardTokenParsers {
  lexical.reserved += 
    ("to", "buy", "sell", "min", "max", "for", "account", "shares", "at")

  lexical.delimiters += ("(", ")", ",")

  import AST._ 

  lazy val order: Parser[Order] = 
    items ~ account_spec ^^ { case i ~ a => Order(i, a) }

  lazy val items: Parser[Items] = 
    "(" ~> rep1sep(line_item, ",") <~ ")" ^^ Items

  lazy val line_item: Parser[LineItem] = 
    security_spec ~ buy_sell ~ price_spec ^^ 
      { case s ~ b ~ p => LineItem(s, b, p) }

  lazy val buy_sell: Parser[BuySell] = 
    "to" ~> ("buy" ^^^ BUY | "sell" ^^^ SELL)

  lazy val security_spec: Parser[SecuritySpec] = 
    numericLit ~ (ident <~ "shares") ^^ 
      { case n ~ s => SecuritySpec(n.toInt, s) }

  lazy val price_spec: Parser[PriceSpec] = 
    "at" ~> (min_max?) ~ numericLit ^? 
      ({ case m ~ p if p.toInt > 20 => PriceSpec(m, p.toInt) }, 
        ( m => "price needs to be > 20" ))

  lazy val min_max: Parser[PriceType] = 
    "min" ^^^ MIN | "max" ^^^ MAX

  lazy val account_spec: Parser[AccountSpec] = 
    "for" ~> "account" ~> stringLit ^^ AccountSpec
}
