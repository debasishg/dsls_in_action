// Listing 4.7 & 4.8 Dynamic Builders for Trade objects in Groovy

package ch4.groovy.trade

class Trade {
    String refNo
    Account account
    Instrument instrument
    List<Taxfee> taxfees = []
}

class Account {
    String no
    String name
    String type
}

class Instrument {
    String isin
    String type
    String name
}

class Taxfee {
    String taxId
    BigDecimal value
}

