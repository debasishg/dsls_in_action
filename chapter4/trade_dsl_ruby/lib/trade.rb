## Listing 4.6 Trade abstraction in Ruby                                                                            [Ruby]

require 'trade_validation'
require 'enable_trade_validation'

class Trade
  include EnableTradeValidation
  
  attr_accessor :ref_no, :account, :instrument, :principal
  trd_validate :principal do |val|
    val > 0
  end

  def initialize(ref, acc, ins, prin)
    @ref_no = ref
    @account = acc
    @instrument = ins
    @principal = prin
  end

  def with(*args)   #1
    args.inject(self) { |memo, val| memo.extend val }
  end

  def value
    @principal
  end

  def to_s()
    "Reference: "         + @ref_no.to_s            +
    "\nAccount: "         + @account.to_s           +
    "\nInstrument: "      + @instrument.to_s        +
    "\nPrincipal: "       + @principal.to_s 
  end
end
