package ch5.order

class OrderCategory {
  static void buy(Script self, Order o) {
    println "Buy: $o"
  }

  static void sell(Script self, Order o) {
    println "Sell: $o"
  }
}

