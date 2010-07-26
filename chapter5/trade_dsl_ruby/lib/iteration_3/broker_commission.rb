## Listing 5.9 Calculating the trade cash value

module BrokerCommission
  def value
    @c = @p * 0.1 if @c.nil?
    super - @c
  end
end
