// Listing 4.11 Trade with typed constraints                                                                     

package ch4.trade

trait Account
trait Trading extends Account
trait Settlement extends Account

trait Trade {
  type A <: Trading

  val account: A
  def valueOf: Unit
}

// Listing 4.12 Equity Trade and Fixed Income Trade

trait Instrument
trait Stock extends Instrument
trait FixedIncome extends Instrument

trait EquityTrade extends Trade {
  type S <: Stock

  val equity: S
  def valueOf {
    //..
  }
}

trait FixedIncomeTrade extends Trade {
  type FI <: FixedIncome

  val fi: FI
  def valueOf {
    //..
  }
}

