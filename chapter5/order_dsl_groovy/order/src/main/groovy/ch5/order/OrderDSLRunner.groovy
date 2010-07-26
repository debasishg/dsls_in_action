package ch5.order

class DslRunner {
  static runDSL(dsl) {
    use(OrderCategory, StockCategory) {
      new GroovyClassLoader().parseClass(dsl as File).newInstance().run()
    }
  }
}
