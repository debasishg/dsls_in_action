## Listing 5.9 Calculating the trade cash value

module TaxFee
  def value
    @t = @p * 0.2 if @t.nil?
    super + @t
  end
end
