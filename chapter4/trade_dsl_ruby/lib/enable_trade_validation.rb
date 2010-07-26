## Listing 4.13 Trade with domain validation

require 'trade_validation'
module EnableTradeValidation
  def self.included(base)
    base.extend TradeValidation
  end
end
