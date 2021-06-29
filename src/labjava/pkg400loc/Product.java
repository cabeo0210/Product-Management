
package labjava.pkg400loc;

public class Product {
    public String productID;
    public String productName;
    public double price;
    public int quantity;
    public String categoryID;

    public String getProductName() {
        return productName;
    }

    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public Product( String productID, String productName, double price, int quantity, String categoryID ) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID( String productID ) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID( String categoryID ) {
        this.categoryID = categoryID;
    }
}

