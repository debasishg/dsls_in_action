module TradeValidation
  def trd_validate(attribute, &check)
    define_method "#{attribute}=" do |val|
      raise 'Validation failed' unless check.call(val)
      instance_variable_set("@#{attribute}", val)
    end

    define_method attribute do
      instance_variable_get "@#{attribute}"
    end
  end
end
