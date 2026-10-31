package GiaiDoan1.challenge03;

public class OrderItem {
    private String itemName;
    private double unitPrice;
    private int quantity;

    public OrderItem(String itemName, double unitPrice, int quantity) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public OrderItem(OrderItem other) {
        if (other != null) {
            this.itemName = other.itemName;
            this.unitPrice = other.unitPrice;
            this.quantity =other.quantity;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
