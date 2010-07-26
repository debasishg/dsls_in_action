module TaxFee
  def value
    super + principal * 0.2
  end
end
