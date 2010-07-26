parser grammar OrderParser;

options {
  tokenVocab = OrderLexer;
}

@header {
  package ch7.order;
  import java.util.List;
  import java.util.ArrayList;
}

@members {
  private List<Order> orders = new ArrayList<Order>();
  public List<Order> getOrders() {
    return orders;
  }
}

orders : order+ EOF;
order  : line NEWLINE {orders.add($line.value);};

line returns [Order value]
  : (e=BUY | e=SELL) security price account
    {
      $value = new Order($e.text, $security.value, 
                 $price.value, $account.value);
    };

security returns [String value]: ID {$value = $ID.text;};

limitprice returns [int value] 
  : LPRICE EQ INT {$value = Integer.parseInt($INT.text);};

price returns [int value] : AT 
  (
    INT {$value = Integer.parseInt($INT.text);}
    | 
    limitprice {$value = $limitprice.value;}
  );

account returns [String value] : FOR ID {$value = $ID.text;};
