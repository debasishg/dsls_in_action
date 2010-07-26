// Listing 7.5 Processor.java – The driver code for our parser module

package ch7.order;

import java.io.*;
import java.util.List;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Processor {

  public static void main(String[] args)
    throws IOException, RecognitionException {
    List<Order> os =
      new Processor().processFile(args[0]);
    for(Order o : os) {
      System.out.println(o);
    }
  }

  private List<Order> processFile(String filePath)
    throws IOException, RecognitionException {
    OrderParser p =
      new OrderParser(
        getTokenStream(new FileReader(filePath)));
    p.orders();
    return p.getOrders();
  }

  private CommonTokenStream getTokenStream(Reader reader)
    throws IOException {
    OrderLexer lexer =
      new OrderLexer(new ANTLRReaderStream(reader));
    return new CommonTokenStream(lexer);
  }
}
