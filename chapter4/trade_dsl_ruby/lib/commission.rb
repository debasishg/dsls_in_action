module Commission
  def value
    super - principal * 0.1
  end
end
