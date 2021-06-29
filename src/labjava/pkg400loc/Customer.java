
package labjava.pkg400loc;

import java.util.ArrayList;

public class Customer {
    public String customerName;
    ArrayList<Order> list;

    public Customer( String customerName, ArrayList<Order> list ) {
        this.customerName = customerName;
        this.list = list;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName( String customerName ) {
        this.customerName = customerName;
    }

    public ArrayList<Order> getList() {
        return list;
    }

    public void setList( ArrayList<Order> list ) {
        this.list = list;
    }

    public void addOrder(Order order){
        list.add(order);
    }
}

