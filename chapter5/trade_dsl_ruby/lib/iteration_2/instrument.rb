## Listing 5.4 Instrument traded in Ruby

class Instrument
  attr_accessor :name, :quantity
  def initialize(name)
    @name = name
  end

  def to_s()
    "(Name: " + @name.to_s            +
    "/Quantity: " + @quantity.to_s    + ")"
  end
end
