

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.javasupport.util.RuntimeHelpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class Registry extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("## Listing 4.1 DSL to create a client account                                                                     [Ruby]\n" +
            "\n" +
            "require 'account'\n" +
            "require 'mailer'\n" +
            "\n" +
            "class Registry\n" +
            "  def self.register(a)\n" +
            "    puts \"Registering #{a}\"\n" +
            "  end\n" +
            "end\n" +
            "\n" +
            "Account.create do \n" +
            "\n" +
            "  number      \"CL-BXT-23765\"\n" +
            "  holders     \"John Doe\", \"Phil McCay\"\n" +
            "  address     \"San Francisco\"\n" +
            "  type        \"client\"\n" +
            "  email       \"client@example.com\"\n" +
            "\n" +
            "end.save.and_then do |a| \n" +
            "\n" +
            "  Registry.register(a)\n" +
            "  Mailer.new.to(a.email_address).cc(a.email_address).subject(\"New Account Creation\").body(\"Client account created for #{a.no}\").send\n" +
            "end\n" +
            "").toString();
        __ruby__.executeScript(source, "run_script.rb");
        RubyClass metaclass = __ruby__.getClass("Registry");
        metaclass.setRubyStaticAllocator(Registry.class);
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: Registry");
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private Registry(Ruby ruby, RubyClass metaclass) {
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
        return new Registry(ruby, metaClass);
    }
        
    /**
     * Default constructor. Invokes this(Ruby, RubyClass) with the classloader-static
     * Ruby and RubyClass instances assocated with this class, and then invokes the
     * no-argument 'initialize' method in Ruby.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public Registry() {
        this(__ruby__, __metaclass__);
        RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "initialize");
    }

    
    public static Object register(Object a) {
        IRubyObject ruby_a = JavaUtil.convertJavaToRuby(__ruby__, a);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), __metaclass__, "register", ruby_a);
        return (Object)ruby_result.toJava(Object.class);

    }

}
