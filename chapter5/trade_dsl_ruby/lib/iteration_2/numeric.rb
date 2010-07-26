## Listing 5.5 Instrument DSL through Monkey-patching

require 'instrument'
class Numeric
  def shares
    self
  end

  alias :share :shares

  def of instrument
    if instrument.kind_of? String
      instrument = Instrument.new(instrument)
    end
    instrument.quantity = self
    instrument
  end
end