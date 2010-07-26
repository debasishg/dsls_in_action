

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.javasupport.util.RuntimeHelpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class Mailer extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("## Listing 4.4 Mailer class with fluent interfaces                                                               [Ruby]\n" +
            "\n" +
            "class Mailer\n" +
            "  attr_reader :mail_to, :mail_cc, :mail_subject, :mail_body\n" +
            "\n" +
            "  def to(*to_recipients)\n" +
            "    @mail_to = to_recipients\n" +
            "    self\n" +
            "  end\n" +
            "\n" +
            "  def cc(*cc_recipients)\n" +
            "    @mail_cc = cc_recipients\n" +
            "    self\n" +
            "  end\n" +
            "\n" +
            "  def subject(subj)\n" +
            "    @mail_subject = subj\n" +
            "    self\n" +
            "  end\n" +
            "\n" +
            "  def body(b)\n" +
            "    @mail_body = b\n" +
            "    self\n" +
            "  end\n" +
            "\n" +
            "  def send\n" +
            "    # actual send\n" +
            "    puts \"sending mail to (#{@mail_to.join(\",\")})\"\n" +
            "  end\n" +
            "end\n" +
            "").toString();
        __ruby__.executeScript(source, "mailer.rb");
        RubyClass metaclass = __ruby__.getClass("Mailer");
        metaclass.setRubyStaticAllocator(Mailer.class);
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: Mailer");
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private Mailer(Ruby ruby, RubyClass metaclass) {
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
        return new Mailer(ruby, metaClass);
    }
        
    /**
     * Default constructor. Invokes this(Ruby, RubyClass) with the classloader-static
     * Ruby and RubyClass instances assocated with this class, and then invokes the
     * no-argument 'initialize' method in Ruby.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public Mailer() {
        this(__ruby__, __metaclass__);
        RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "initialize");
    }

    
    public Object to(Object to_recipients) {
        IRubyObject ruby_to_recipients = JavaUtil.convertJavaToRuby(__ruby__, to_recipients);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "to", ruby_to_recipients);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object cc(Object cc_recipients) {
        IRubyObject ruby_cc_recipients = JavaUtil.convertJavaToRuby(__ruby__, cc_recipients);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "cc", ruby_cc_recipients);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object subject(Object subj) {
        IRubyObject ruby_subj = JavaUtil.convertJavaToRuby(__ruby__, subj);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "subject", ruby_subj);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object body(Object b) {
        IRubyObject ruby_b = JavaUtil.convertJavaToRuby(__ruby__, b);
        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "body", ruby_b);
        return (Object)ruby_result.toJava(Object.class);

    }

    
    public Object send() {

        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "send");
        return (Object)ruby_result.toJava(Object.class);

    }

}
