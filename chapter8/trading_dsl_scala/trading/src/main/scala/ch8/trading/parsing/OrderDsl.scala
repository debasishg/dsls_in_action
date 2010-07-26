// Listing 8.2 A sample external DSL using Scala Parser Combinators

package ch8.trading.parsing
package dsl

import scala.util.parsing.combinator.syntactical._

object OrderDsl extends StandardTokenParsers {
  lexical.reserved += 
    ("to", "buy", "sell", "min", "max", "for", "account", "shares", "at")
  lexical.delimiters += ("(", ")", ",")

  lazy val order = 
    items ~ account_spec

  lazy val items = 
    "(" ~> rep1sep(line_item, ",") <~ ")"

  lazy val line_item = 
    security_spec ~ buy_sell ~ price_spec 

  lazy val buy_sell = 
    "to" ~> "buy" | "to" ~> "sell"

  lazy val security_spec = 
      numericLit ~ (ident <~ "shares") 

  lazy val price_spec = 
    "at" ~> (min_max?) ~ numericLit 

  lazy val min_max = 
      "min" | "max" 

  lazy val account_spec = 
    "for" ~> "account" ~> stringLit 
}
