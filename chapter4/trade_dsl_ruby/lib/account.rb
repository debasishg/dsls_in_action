## Listing 4.2 Expressive domain vocabulary in implementation of Account                [Ruby]

class Account
  attr_reader :no, :names, :addr, :type, :email_address

  def number(number)
    @no = number
  end

  def holders(*names)
    @names = names
  end

  def address(addr)
    @addr = addr
  end

  def type(t)
    @type = t
  end

  def email(e)
    @email_address = e
  end

  def to_s()
    "No: " + @no.to_s +
    " / Names: (" + @names.join(',').to_s +
    ") / Address: " + @addr.to_s
  end

  def save
    # save to db
    self
  end

  def self.create(&block)
    account = Account.new
    account.instance_eval(&block)
    account
  end

  def and_then(&block)
    instance_eval(&block)
  end
end
