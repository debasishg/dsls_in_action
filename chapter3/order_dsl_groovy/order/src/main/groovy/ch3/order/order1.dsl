// Listing 3.7 order1.dsl : The DSL script now returns a Closure
{->
orders = []
ord1 =
newOrder.to.buy(100.shares.of('IBM')) {
  limitPrice   300
  allOrNone    true
  valueAs      {qty, unitPrice -> qty * unitPrice - 500}
}
orders << ord1

ord2 =
newOrder.to.buy(150.shares.of('GOOG')) {
  limitPrice   300
  allOrNone    true
  valueAs      {qty, unitPrice -> qty * unitPrice - 500}
}
orders << ord2

ord3 =
newOrder.to.buy(200.shares.of('MSOFT')) {
  limitPrice   300
  allOrNone    true
  valueAs      {qty, unitPrice -> qty * unitPrice - 500}
}
orders << ord3

println "Orders ..."
orders.each { println it }
}
