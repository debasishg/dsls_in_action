// Listing 5.12 Adding methods to Integer using Categories
package ch5.order

class StockCategory {
  static Stock getGOOG(Integer self) {
    new Stock(new Order("GOOG", self))
  }

  static Stock getIBM(Integer self) {
    new Stock(new Order("IBM", self))
  }

  static Stock getMSOFT(Integer self) {
    new Stock(new Order("MSOFT", self))
  }
}
