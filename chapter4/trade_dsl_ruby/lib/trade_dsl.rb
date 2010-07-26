require 'trade'
require 'tax_fee'
require 'commission'

tr = Trade.new('r-123', 'a-123', 'i-123', 20000).with TaxFee, Commission
puts tr.value
