
package labjava.pkg400loc;

import java.util.Scanner;

public class MainClass {
    public static int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== MAIN MENU ===============");
        System.out.println("1. Add new category");
        System.out.println("2. Update category");
        System.out.println("3. Add new product");
        System.out.println("4. Update product");
        System.out.println("5. Order product");
        System.out.println("6. Show order list report");
        System.out.println("7. Read data from file!");
        System.out.println("Others- Quit Program");
        System.out.print("Your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void main( String[] args ) {
        CategoryManager listCategory = new CategoryManager();
        ProductManager listProduct = new ProductManager(listCategory);
        int choice;
        do {
            choice = menu();
            switch (choice) {
                case 1:{
                    listCategory.addCategory();
                    break;
                }

                case 2:{
                    listCategory.updateCategory();
                    break;
                }

                case 3:{
                    listProduct.addProduct();
                    break;
                }

                case 4:{
                    listProduct.updateProduct();
                    break;
                }

                case 5:{
                    listProduct.orderProduct();
                    break;
                }

                case 6:{
                    listProduct.displayCustomer();
                    break;
                }

                case 7:{
                    listProduct.readFromFile();
                    System.out.println("Read from file success!");
                    break;
                }
            }
        } while (choice>=1 && choice<=7);
    }
}

