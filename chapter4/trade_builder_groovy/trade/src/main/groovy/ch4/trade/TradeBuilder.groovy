// Listing 4.7 Trade abstraction in Groovy
// For dynamic builders and the DSL script of listign 4.8 have a look at the script embedded in the pom

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

