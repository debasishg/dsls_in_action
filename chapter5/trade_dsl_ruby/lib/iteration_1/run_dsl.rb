require 'instrument'
require 'numeric'
require 'trade_dsl'

trd =
TradeDSL.new.new_trade 'T-12435',
  'acc-123', :buy, 100.shares.of('IBM'),
  'unitprice' => 200, 'principal' => 120000, 'tax' => 5000

puts trd
