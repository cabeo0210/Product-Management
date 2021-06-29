
package labjava.pkg400loc;

public class Order {
    public String productName;
    public int quantity;
    public double price;
    public double amount;

    public String getProductName() {
        return productName;
    }

    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount( double amount ) {
        this.amount = amount;
    }

    public Order( String productName, int quantity, double price, double amount ) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }
}

