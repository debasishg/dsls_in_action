## Listing 5.1 Polymorphism with duck typing

class SecurityTrade
  ## ..
  def value_of
    puts "In security trade value_of"
  end
end

class ForexTrade
  ## ..
  def value_of
    puts "In forex trade value_of"
  end
end

def cash_value(trade)
  trade.value_of
end

cash_value(SecurityTrade.new)
cash_value(ForexTrade.new)
