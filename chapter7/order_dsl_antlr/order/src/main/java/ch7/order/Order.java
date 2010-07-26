// Listing 7.4 Order.java – The Order abstraction

package ch7.order;

public class Order {
  private String buySell;
  private String security;
  private int price;
  private String account;

  public Order(String bs, String sec, int p, String acc) {
    buySell = bs;
    security = sec;
    price = p;
    account = acc;
  }

  public String toString() {
    return new StringBuilder()
      .append("Order is ")
      .append(buySell)
      .append("/")
      .append(security)
      .append("/")
      .append(price)
      .append("/")
      .append(account)
      .toString();
  }
}
