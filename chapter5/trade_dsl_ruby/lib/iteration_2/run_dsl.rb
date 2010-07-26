require 'trade_dsl'
require 'security_trade'
require 'instrument'
require 'numeric'

str = <<END_OF_STRING
  new_trade 'T-12435' for account 'acc-123' to buy 100 shares of 'IBM',
                      at UnitPrice=100, Principal=12000, Tax=500
END_OF_STRING

puts TradeDSL.trade str
