package ch2.order;

public class Main {
    public static void main(String[] args) {
        Order o =
            new Order.Builder()
                     .buy(100, "IBM")
                     .atLimitPrice(300)
                     .allOrNone()
                     .valueAs(new OrderValuerImpl())
                     .build();
        System.out.println(o);
    }
}
