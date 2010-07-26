

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.javasupport.util.RuntimeHelpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class Account extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("## Listing 4.2 Expressive domain vocabulary in implementation of Account                [Ruby]\n" +
            "\n" +
            "class Account\n" +
            "  attr_reader :no, :names, :addr, :type, :email_address\n" +
            "\n" +
            "  def number(number)\n" +
            "    @no = number\n" +
            "  end\n" +
            "\n" +
            "  def holders(*names)\n" +
            "    @names = names\n" +
            "  end\n" +
            "\n" +
            "  def address(addr)\n" +
            "    @addr = addr\n" +
            "  end\n" +
            "\n" +
            "  def type(t)\n" +
            "    @type = t\n" +
            "  end\n" +
            "\n" +
            "  def email(e)\n" +
            "    @email_address = e\n" +
            "  end\n" +
            "\n" +
            "  def to_s()\n" +
            "    \"No: \" + @no.to_s +\n" +
            "    \" / Names: (\" + @names.join(',').to_s +\n" +
            "    \") / Address: \" + @addr.to_s\n" +
            "  end\n" +
            "\n" +
            "  def save\n" +
            "    # save to db\n" +
            "    self\n" +
            "  end\n" +
            "\n" +
            "  def self.create(&block)\n" +
            "    account = Account.new\n" +
            "    account.instance_eval(&block)\n" +
            "    account\n" +
            "  end\n" +
            "\n" +
            "  def and_then(&block)\n" +
            "    instance_eval(&block)\n" +
            "  end\n" +
            "end\n" +
            "").toString();
        __ruby__.executeScript(source, "account.rb");
        RubyClass metaclass = __ruby__.getClass("Account");
        metaclass.setRubyStaticAllocator(Account.class);
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: Account");
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private Account(Ruby ruby, RubyClass metaclass) {
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
        return new Account(ruby, metaClass);
    }
        
    /**
     * Default constructor. Invokes this(Ruby, RubyClass) with the classloader-static
     * Ruby and RubyClass instances assocated with this class, and then invokes the
     * no-argument 'initialize' method in Ruby.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public Account() {
        this(__ruby__, __metaclass__);
        RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "initialize");
    }

    
    public Object number(Object number) {
        IRubyObject ruby_number = JavaUtil.convertJavaToRuby(__ruby__, number);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "number", ruby_number);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object holders(Object names) {
        IRubyObject ruby_names = JavaUtil.convertJavaToRuby(__ruby__, names);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "holders", ruby_names);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object address(Object addr) {
        IRubyObject ruby_addr = JavaUtil.convertJavaToRuby(__ruby__, addr);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "address", ruby_addr);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object type(Object t) {
        IRubyObject ruby_t = JavaUtil.convertJavaToRuby(__ruby__, t);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "type", ruby_t);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object email(Object e) {
        IRubyObject ruby_e = JavaUtil.convertJavaToRuby(__ruby__, e);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "email", ruby_e);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object to_s() {

        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "to_s");
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object save() {

        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "save");
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public static Object create(Object block) {
        IRubyObject ruby_block = JavaUtil.convertJavaToRuby(__ruby__, block);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), __metaclass__, "create", ruby_block);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object and_then(Object block) {
        IRubyObject ruby_block = JavaUtil.convertJavaToRuby(__ruby__, block);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "and_then", ruby_block);
        return (Object)ruby_result.toJava(Object.class);

    }

}
