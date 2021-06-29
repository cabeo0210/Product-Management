
package labjava.pkg400loc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProductManager {
    ArrayList<Product> list = new ArrayList<>();
    CategoryManager listCategory;
    ArrayList<Customer> listCustomer = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductManager(CategoryManager listCategory) {
        this.listCategory = listCategory;
    }

    public void addProduct() {
        String productID;
        String productName;
        double price = 0;
        int quantity=0;
        String categoryID;
        boolean check;
        do {
            System.out.print("Enter the ID of new product: ");
            productID = scanner.nextLine();
            check=true;
            if (findProduct(productID)){
                check = false;
                System.out.println("Product ID cannot be duplicated");
            }
        } while (!check);
        System.out.print("Enter the name of new product: ");
        productName = scanner.nextLine();
        do {
            System.out.print("Enter the price of new product: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                check = true;
            } catch (Exception e) {
                System.out.println("Price must be positive integer");
                check = false;
            }
            if (price<0) {
                System.out.println("Price must be positive integer");
                check = false;
            }
        } while (!check);
        do {
            System.out.print("Enter the quantity of new product: ");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                check = true;
            } catch (Exception e) {
                System.out.println("Quantity must be positive integer");
                check=false;
            }
            if (quantity<=0) {
                System.out.println("Quantity must be positive integer");
                check = false;
            }
        } while (!check);
        do {
            System.out.print("Enter the category ID of new product: ");
            categoryID = scanner.nextLine();
            check = true;
            if ( listCategory.findCategory(categoryID) ) {
                check = false;
                System.out.println("Category ID must be included in category!");
            }
        } while (!check);
        Product product = new Product(productID,productName,price,quantity,categoryID);
        list.add(product);
        System.out.println("\n===ADD SUCCESSFULLY===");
    }

    public void updateProduct(){
        System.out.print("Enter the ID of product to be updated: ");
        String productID = scanner.nextLine();
        if (!findProduct(productID)) {
            System.out.println("This product ID does not exist!");
        } else {
            System.out.println("====UPDATE AND DELETE MENU====");
            System.out.println("1. Update");
            System.out.println("2. Delete");
            System.out.println("3. Back to main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:{
                    System.out.println("Just press ENTER. The system won't change the old information!");
                    String productName;
                    double price=0;
                    boolean check;
                    int quantity=0;
                    String categoryID;
                    Product product = getProduct(productID);
                    System.out.print("Enter the new name of product: ");
                    productName = scanner.nextLine();
                    if (!productName.equals(""))
                        product.setProductName(productName);
                    do {
                        System.out.print("Enter the new price of product: ");
                        try {
                            String priceStr = scanner.nextLine();
                            if (priceStr.equals("")) {
                                check = false;
                                break;
                            }
                            price = Double.parseDouble(priceStr);
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Price must be positive integer");
                            check = false;
                        }
                        if (price<0) {
                            System.out.println("Price must be positive integer");
                            check = false;
                        }
                    } while (!check);
                    if (check) {
                        product.setPrice(price);
                    }
                    do {
                        System.out.print("Enter the new quantity of product: ");
                        try {
                            String quantityStr = scanner.nextLine();
                            if (quantityStr.equals("")) {
                                check = false;
                                break;
                            }
                            quantity = Integer.parseInt(quantityStr);
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Quantity must be positive integer");
                            check=false;
                        }
                        if (quantity<=0) {
                            System.out.println("Quantity must be positive integer");
                            check = false;
                        }
                    } while (!check);
                    if (check) {
                        product.setQuantity(quantity);
                    }
                    do {
                        System.out.print("Enter the new category ID of product: ");
                        categoryID = scanner.nextLine();
                        if (categoryID.equals("")) {
                            check = false;
                            break;
                        }
                        check = true;
                        if ( listCategory.findCategory(categoryID) ) {
                            check = false;
                            System.out.println("Category ID must be included in category!");
                        }
                    } while (!check);
                    if (check) {
                        product.setCategoryID(categoryID);
                    }
                    System.out.println("===UPDATE SUCCESS===");
                    break;
                }

                case 2: {
                    System.out.println("Do you want to delete this product (Yes/No)?");
                    System.out.print("Answer: ");
                    String answer = scanner.nextLine();
                    if (answer.equals("Yes")) {
                        list.remove(getProduct(productID));
                    }
                    System.out.println("===DELETE SUCCESS===");
                    break;
                }
            }
        }
    }

    public void displayAll(){
        System.out.println("Products listing: ");
        System.out.printf("%12s%21s%14s\n","| ++ No ++ |"," ++ Product name ++ |"," ++ Price ++ |");
        int i =0;
        for (Product product: list) {
            i++;
            System.out.printf("%12s%21s%14s\n",("      "+i+"     "),("    "+product.getProductName()),("  "+product.getPrice()+" $"));
        }
    }

    public void orderProduct() {
        displayAll();
        System.out.print("Select No of product: ");
        int i =Integer.parseInt(scanner.nextLine());
        Product product =list.get(i-1);
        System.out.println("You selected: "+product.productName);
        System.out.print("Please input quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.printf("%16s%17s%14s%15s\n","| ++ Product ++ |"," ++ Quantity ++ |"," ++ Price ++ |"," ++ Amount ++ |");
        System.out.printf("%16s%17s%14s%15s\n",("    "+product.productName),("   "+quantity +"   "),("  "+product.price+" $"),("   "+(product.price*quantity)+" $"));
        System.out.println("Total: "+product.price*quantity+" $");
        System.out.print("Input your name: ");
        String customerName = scanner.nextLine();
        System.out.println("===ADD SUCCESS====");
        boolean check = false;
        Customer customerResult = null;
        if (listCustomer.size()>0) {
            for ( Customer customer : listCustomer ) {
                if ( customer.getCustomerName().equals(customerName) ) {
                    check = true;
                    customerResult = customer;
                    break;
                }
            }
        }
        Order order = new Order(product.productName,quantity,product.price,product.price*quantity);
        if (check) {
            customerResult.getList().add(order);
        } else {
            ArrayList<Order> list1 = new ArrayList<>();
            list1.add(order);
            Customer customer = new Customer(customerName,list1);
            listCustomer.add(customer);
        }
    }

    public void displayCustomer(){
        for (Customer customer:listCustomer) {
            System.out.println("Customer: "+customer.customerName);
            System.out.printf("%9s%11s%8s%7s\n","Product |"," Quantity |"," Price |"," Amount");
            for (Order order:customer.getList()){
                System.out.printf("%9s%11s%8s%7s\n",order.getProductName(),order.getQuantity(),(order.getPrice()+" $"),(order.getAmount()+ " $"));
            }
            System.out.println("-------------------------------------------");
        }
    }

    public void readFromFile(){
        try {
            FileReader fr1 = new FileReader("product.txt");
            BufferedReader br = new BufferedReader(fr1);
            String line;
            while ((line = br.readLine())!=null){
                StringTokenizer stk = new StringTokenizer(line,"/");
                String productID = stk.nextToken();
                String productName = stk.nextToken();
                double price = Double.parseDouble(stk.nextToken());
                int quantity = Integer.parseInt(stk.nextToken());
                String categoryID = stk.nextToken();
                Product product = new Product(productID,productName,price,quantity,categoryID);
                list.add(product);
            }
            FileReader fr2 = new FileReader("category.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            while ((line = br2.readLine())!=null) {
                StringTokenizer stk = new StringTokenizer(line,"/");
                String ID = stk.nextToken();
                String name = stk.nextToken();
                Category category = new Category(ID,name);
                listCategory.list.add(category);
            }
            fr1.close();
            fr2.close();
            br.close();
            br2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean findProduct(String productID) {
        for (Product product:list) {
            if (product.getProductID().equals(productID))
                return true;
        }
        return false;
    }

    public Product getProduct(String productID) {
        for (Product product:list) {
            if (product.getProductID().equals(productID))
                return product;
        }
        return null;
    }
}

