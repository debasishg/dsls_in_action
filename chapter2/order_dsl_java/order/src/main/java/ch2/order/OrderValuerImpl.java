package ch2.order;

public class OrderValuerImpl implements OrderValuer {
    public int valueAs(int qty, int unitPrice) {
        return unitPrice * qty;
    }
}
