## Listing 5.7 Using the Trade DSL

require 'trade_dsl'
require 'cash_value_calculator'
require 'tax_fee'
require 'broker_commission'

str = <<END_OF_STRING
new_trade 'T-12435' for account 'acc-123' to buy 100 shares of 'IBM',
                    at UnitPrice = 100
END_OF_STRING

TradeDSL.trade str do |t|

  CashValueCalculator.new(t).with TaxFee, BrokerCommission do |cv|

    t.cash_value = cv.value 
    t.principal = cv.p
    t.tax = cv.t
    t.commission = cv.c
  end
  puts t
end
