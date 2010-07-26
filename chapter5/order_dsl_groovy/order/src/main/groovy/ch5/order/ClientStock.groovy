package ch5.order

class Stock {
  def order

  Stock(orderObject) {
    order = orderObject
  }

  def shares(closure) {
    closure = closure.clone()
    closure.delegate = order
    closure()
    order
  }
}

