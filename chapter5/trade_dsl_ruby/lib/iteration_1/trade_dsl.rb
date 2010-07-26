require 'security_trade'
class TradeDSL
  def new_trade(ref_no, account, buy_sell, instrument, attributes)
    SecurityTrade.create(ref_no, account, buy_sell, instrument, attributes)
  end
end
