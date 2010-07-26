## Listing 4.4 Mailer class with fluent interfaces                                                               [Ruby]

class Mailer
  attr_reader :mail_to, :mail_cc, :mail_subject, :mail_body

  def to(*to_recipients)
    @mail_to = to_recipients
    self
  end

  def cc(*cc_recipients)
    @mail_cc = cc_recipients
    self
  end

  def subject(subj)
    @mail_subject = subj
    self
  end

  def body(b)
    @mail_body = b
    self
  end

  def send
    # actual send
    puts "sending mail to (#{@mail_to.join(",")})"
  end
end
