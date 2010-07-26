// Listing 5.11 Order processing DSL script

buy 200.GOOG.shares {
    limitPrice 300
    allOrNone()
    valueAs {qty * unitPrice - 500}
}

buy 200.IBM.shares {
    limitPrice 300
    allOrNone()
    valueAs {qty * unitPrice - 500}
}

buy 200.MSOFT.shares {
    limitPrice 300
    allOrNone()
    valueAs {qty * unitPrice - 500}
}
