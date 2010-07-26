

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.javasupport.util.RuntimeHelpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class Trade extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("## Listing 4.6 Trade abstraction in Ruby                                                                            [Ruby]\n" +
            "\n" +
            "require 'trade_validation'\n" +
            "require 'enable_trade_validation'\n" +
            "\n" +
            "class Trade\n" +
            "  include EnableTradeValidation\n" +
            "  \n" +
            "  attr_accessor :ref_no, :account, :instrument, :principal\n" +
            "  trd_validate :principal do |val|\n" +
            "    val > 0\n" +
            "  end\n" +
            "\n" +
            "  def initialize(ref, acc, ins, prin)\n" +
            "    @ref_no = ref\n" +
            "    @account = acc\n" +
            "    @instrument = ins\n" +
            "    @principal = prin\n" +
            "  end\n" +
            "\n" +
            "  def with(*args)   #1\n" +
            "    args.inject(self) { |memo, val| memo.extend val }\n" +
            "  end\n" +
            "\n" +
            "  def value\n" +
            "    @principal\n" +
            "  end\n" +
            "\n" +
            "  def to_s()\n" +
            "    \"Reference: \"         + @ref_no.to_s            +\n" +
            "    \"\\nAccount: \"         + @account.to_s           +\n" +
            "    \"\\nInstrument: \"      + @instrument.to_s        +\n" +
            "    \"\\nPrincipal: \"       + @principal.to_s \n" +
            "  end\n" +
            "end\n" +
            "").toString();
        __ruby__.executeScript(source, "trade.rb");
        RubyClass metaclass = __ruby__.getClass("Trade");
        metaclass.setRubyStaticAllocator(Trade.class);
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: Trade");
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private Trade(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new Trade(ruby, metaClass);
    }

    
    public  Trade(Object ref, Object acc, Object ins, Object prin) {
        this(__ruby__, __metaclass__);
        IRubyObject ruby_ref = JavaUtil.convertJavaToRuby(__ruby__, ref);
        IRubyObject ruby_acc = JavaUtil.convertJavaToRuby(__ruby__, acc);
        IRubyObject ruby_ins = JavaUtil.convertJavaToRuby(__ruby__, ins);
        IRubyObject ruby_prin = JavaUtil.convertJavaToRuby(__ruby__, prin);
        RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "initialize", ruby_ref, ruby_acc, ruby_ins, ruby_prin);

    }

    
    public Object with(Object args) {
        IRubyObject ruby_args = JavaUtil.convertJavaToRuby(__ruby__, args);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "with", ruby_args);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object value() {

        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "value");
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object to_s() {

        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "to_s");
        return (Object)ruby_result.toJava(Object.class);

    }

}
