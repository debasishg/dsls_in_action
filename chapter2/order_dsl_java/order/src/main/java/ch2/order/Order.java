// Listing 2.1 Order abstraction for Java DSL

package ch2.order;

public class Order {
    static class Builder {
        private String security;
        private int quantity;
        private int limitPrice;
        private boolean allOrNone;
        private int value;
        private String bs;

        public Builder() {}
        public Builder buy(int quantity, String security) {
            bs = "Bought";
            this.quantity = quantity;
            this.security = security;
            return this;
        }
        public Builder sell(int quantity, String security) {
            bs = "Sold";
            this.quantity = quantity;
            this.security = security;
            return this;
        }
        public Builder atLimitPrice(int p) {
            this.limitPrice = p;
            return this;
        }
        public Builder allOrNone() {
            this.allOrNone = true;
            return this;
        }
        public Builder valueAs(OrderValuer ov) {
            this.value = ov.valueAs(quantity, limitPrice);
            return this;
        }
        public Order build() {
            return new Order(this);
        }
    }

    private final String security;
    private final int quantity;
    private final int limitPrice;
    private final boolean allOrNone;
    private int value;
    private final String bs;

    private Order(Builder b) {
        security = b.security;
        quantity = b.quantity;
        limitPrice = b.limitPrice;
        allOrNone = b.allOrNone;
        value = b.value;
        bs = b.bs;
    }

    public boolean isAllOrNone() {
        return allOrNone;
    }

    public String getBs() {
        return bs;
    }

    public int getLimitPrice() {
        return limitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSecurity() {
        return security;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
		return new StringBuilder()
		    .append(bs)
		    .append(" " + quantity + " shares of ")
		    .append(security)
		    .append(" with limit price ")
		    .append(limitPrice)
		    .append(" ")
		    .append(allOrNone == true ? "ALL OR NONE" : "")
		    .toString();
    }
}
