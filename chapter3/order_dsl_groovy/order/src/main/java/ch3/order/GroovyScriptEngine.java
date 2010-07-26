// Listing 3.3 Java Application code that invokes the Groovy DSL
package ch3.order;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class GroovyScriptEngine {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");

        List<?> orders =
                (List<?>)engine.eval(new InputStreamReader(
                    new BufferedInputStream(
                        new SequenceInputStream(
                            new FileInputStream("D:/tech/dsls_in_a/chapter3/order_dsl_groovy/order/src/main/groovy/ch3/order/ClientOrder.groovy"),
                            new FileInputStream("D:/tech/dsls_in_a/chapter3/order_dsl_groovy/order/src/main/groovy/ch3/order/order.dsl")))));

        System.out.println(orders.size());
        for(Object o : orders) {
            System.out.println(o);
        }
    }
}
