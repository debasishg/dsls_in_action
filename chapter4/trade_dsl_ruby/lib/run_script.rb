## Listing 4.1 DSL to create a client account                                                                     [Ruby]

require 'account'
require 'mailer'

class Registry
  def self.register(a)
    puts "Registering #{a}"
  end
end

Account.create do 

  number      "CL-BXT-23765"
  holders     "John Doe", "Phil McCay"
  address     "San Francisco"
  type        "client"
  email       "client@example.com"

end.save.and_then do |a| 

  Registry.register(a)
  Mailer.new.to(a.email_address).cc(a.email_address).subject("New Account Creation").body("Client account created for #{a.no}").send
end
