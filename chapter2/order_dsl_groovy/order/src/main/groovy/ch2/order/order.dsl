ord =
newOrder.to.buy(100.shares.of('IBM')) {
  limitPrice   300
  allOrNone    true
  valueAs      {qty, unitPrice -> qty * unitPrice - 500}
}
println(ord)
