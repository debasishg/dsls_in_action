## Listing 5.3 SecurityTrade in Ruby (Iteration #1)

class SecurityTrade

  attr_reader :ref_no,
              :account,
              :buy_sell,
              :instrument,
              :unitprice

  attr_accessor :principal, :tax,
                :commission

  def initialize(ref_no, account, buy_sell, instrument, unitprice)
    @ref_no = ref_no
    @account, @buy_sell, @instrument, @unitprice =
      account, buy_sell, instrument, unitprice
  end

  def self.create(ref_no, account, buy_sell, instrument, h)  #1
    tr = new(ref_no, account, buy_sell, instrument, h['unitprice'])
    [:principal, :tax, :commission].each do |m|  #2
      tr.instance_eval("tr.#{m} = h['#{m}'] if h.has_key?('#{m}')")
    end
    tr
  end

  def to_s()
    "Reference: "         + @ref_no.to_s            +
    "\nAccount: "         + @account.to_s           +
    "\nBuy/Sell: "        + @buy_sell.to_s          +
    "\nInstrument: "      + @instrument.to_s        +
    "\nUnit Price: "      + @unitprice.to_s         +
    "\nPrincipal: "       + @principal.to_s         +
    "\nTax: "             + @tax.to_s               +
    "\nCommission: "      + @commission.to_s
  end
end
