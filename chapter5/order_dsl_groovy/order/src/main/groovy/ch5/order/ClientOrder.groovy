// Listing 5.10 Order class in Groovy
package ch5.order

class Order {
  def name
  def quantity
  def allOrNone = false
  def limitPrice
  def valueClosure

  def Order(stockName, qty) {
    name = stockName
    quantity = qty
  }

  def limitPrice(price) {limitPrice = price}

  def allOrNone() {allOrNone = true}

  def valueAs(closure) {
    valueClosure = closure.clone()
    valueClosure.delegate =
      [qty: quantity, unitPrice: limitPrice]
  }

  String toString() {
    "stock: $name, number of shares: $quantity, allOrNone: $allOrNone, limitPrice: $limitPrice,valueAs: ${valueClosure()}"
  }
}
