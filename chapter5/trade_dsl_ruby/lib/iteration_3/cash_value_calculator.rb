## Listing 5.9 Calculating the trade cash value

class CashValueCalculator
  attr_reader :trade

  attr_accessor :p, :t, :c
  
  def initialize(trade)
    @trade = trade
    @p = [@trade.principal, @trade.unitprice * @trade.instrument.quantity].find do |m|
      not m.nil? 
    end
    @t = @trade.tax unless @trade.tax.nil?
    @c = @trade.commission unless @trade.commission.nil?
  end

  def with(*args)
    args.inject(self) { |memo, val| memo.extend val }
    yield self if block_given?
  end

  def value
    @p
  end

end
