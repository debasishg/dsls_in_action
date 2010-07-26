// Listing 2.2 Order Processing DSL in Groovy

package ch2.order

class Order {
  def security
  def quantity
  def limitPrice
  def allOrNone
  def value
  def bs

  def buy(su, closure) {
    bs = 'Bought'
    buy_sell(su, closure)
  }

  def sell(su, closure) {
    bs = 'Sold'
    buy_sell(su, closure)
  }

  private buy_sell(su, closure) {
    security = su[0]
    quantity = su[1]
    closure()
  }

  def getTo() {
    this
  }
}

order = new Order()

def methodMissing(String name, args) {
  order.metaClass.getMetaProperty(name).setProperty(order, args)
}

def getNewOrder() {
  order
}

def valueAs(closure) {
  order.value = closure(order.quantity, order.limitPrice[0])
}

Integer.metaClass.getShares = { -> delegate }
Integer.metaClass.of = { instrument ->  [instrument, delegate] }
