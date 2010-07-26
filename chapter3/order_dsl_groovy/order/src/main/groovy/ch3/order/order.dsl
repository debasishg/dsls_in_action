// Listing 3.2 order.dsl : Groovy script for Order Placement

orders = []
newOrder.to.buy(100.shares.of('IBM')) {
  limitPrice   300
  allOrNone    true
  valueAs      {qty, unitPrice -> qty * unitPrice - 500}
}
orders << order

newOrder.to.buy(150.shares.of('GOOG')) {
  limitPrice   300
  allOrNone    true
  valueAs      {qty, unitPrice -> qty * unitPrice - 500}
}
orders << order

newOrder.to.buy(200.shares.of('MSOFT')) {
  limitPrice   300
  allOrNone    true
  valueAs      {qty, unitPrice -> qty * unitPrice - 500}
}
orders << order
orders
