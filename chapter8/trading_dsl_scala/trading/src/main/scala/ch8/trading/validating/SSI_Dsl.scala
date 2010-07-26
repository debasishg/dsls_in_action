// Listing 8.9 The complete DSL that generates our semantic model

package ch8.trading.validating
package dsl

import scala.util.parsing.combinator._

object SSI_Dsl extends JavaTokenParsers 
               with PackratParsers with ValidatingParser {

  import SSI_AST._ 

  lazy val standing_rules: Parser[StandingRules] = 
    (standing_rule +) ^^ StandingRules

  lazy val standing_rule: Parser[StandingRule] = 
    "settle" ~> "trades" ~> trade_type_spec ~ settlement_spec ^^ { case (t ~ s) => StandingRule(t, s) }
        
  lazy val trade_type_spec: PackratParser[TradeTypeRule] =
    trade_type_spec ~ ("in" ~> market <~ "market") ^^ { case (t ~ m) => t.copy(mkt = Some(m)) }  |
    trade_type_spec ~ ("of" ~> security) ^^ { case (t ~ s) => t.copy(sec = Some(s)) } |
    trade_type_spec ~ ("on" ~> "account" ~> account) ^^ { case (t ~ a) => t.copy(tradingAccount = Some(a)) } |
    "for" ~> counterparty_spec ^^ { case c => TradeTypeRule(c, None, None, None) }
    
  lazy val counterparty_spec: Parser[CounterpartyRule] =
    "customer" ~> customer ^^ Customer |
    "broker" ~> broker ^^ Broker

  lazy val settlement_spec =
    settle_all_spec |
    settle_cash_security_separate_spec

  lazy val settle_all_spec: Parser[SettlementRule] = 
    settle_mode_spec ^^ SettleAll

  lazy val settle_cash_security_separate_spec: Parser[SettlementRule] =
    validate(
      repN(2, settle_cash_security ~ settle_mode_spec) ^^ { case l: Seq[_] =>
          SettleCashSecuritySeparate(l map (e => (e._1, e._2))) }
    ) { case (s, in) => {
          val cs = s.set.map(_._1) 
          if ((cs contains SettleSecurity) && (cs contains SettleCash))
            Success(s, in)
          else Failure(
            "should contain 1 entry for cash and security side of settlement", in)
        }
    }

  lazy val settle_cash_security: Parser[SettleCashSecurityRule] =
    "safekeep" ~> "security" ^^^ SettleSecurity |
    "settle" ~> "cash" ^^^ SettleCash

  lazy val settle_mode_spec: Parser[SettlementModeRule] =
    settle_external_spec |
    settle_internal_spec

  lazy val settle_external_spec: Parser[SettlementModeRule] =
    "externally" ~> "at" ~> bank ~ account ^^ { case b ~ a => SettleExternal(b, a) }

  lazy val settle_internal_spec: Parser[SettlementModeRule] =
    "internally" ~> "with" ~> "us" ~> "at" ~> account ^^ SettleInternal

  lazy val market = not(keyword) ~> stringLiteral
  lazy val security = not(keyword) ~> stringLiteral
  lazy val customer = not(keyword) ~> stringLiteral
  lazy val broker = not(keyword) ~> stringLiteral
  lazy val account = not(keyword) ~> stringLiteral
  lazy val bank = not(keyword) ~> stringLiteral

  lazy val keyword =
    "at" | "us" | "of" | "on" | "in" | "and" | "with" |
    "internally" | "externally" | "safekeep" |
    "security" | "settle" | "cash" | "trades" |
    "account" | "customer" | "broker" | "market"
}
