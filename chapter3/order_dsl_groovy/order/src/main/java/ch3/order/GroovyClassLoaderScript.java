// Listing 3.6 RunScript.java : DSL Integration using GroovyClassLoader
package ch3.order;

import groovy.lang.Closure;
import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.codehaus.groovy.control.CompilationFailedException;

public class GroovyClassLoaderScript {
    public static void main(String[] args)
            throws CompilationFailedException, IOException,
                InstantiationException, IllegalAccessException {

        final ClientOrder clientOrder =
                new ClientOrder();

        clientOrder.run();

        final Closure dsl =
            (Closure)((Script) new GroovyClassLoader().parseClass(
                new File("D:/tech/dsls_in_a/chapter3/order_dsl_groovy/order/src/main/groovy/ch3/order/order1.dsl")).newInstance()).run();

        dsl.setDelegate(clientOrder);
        final Object result = dsl.call();

        List<Order> r = (List<Order>) result;
        int val = 0;
        for(Order x : r) {
            val += (Integer)(x.getValue());
        }
        System.out.println(val);
    }
}
