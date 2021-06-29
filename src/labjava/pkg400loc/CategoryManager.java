
package labjava.pkg400loc;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryManager {
    ArrayList<Category> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addCategory() {
        String ID;
        String name;
        boolean check = false;
        do {
            System.out.print("Enter the ID of new category: ");
            ID = scanner.nextLine();
            System.out.print("Enter the name of new category: ");
            name = scanner.nextLine();
            check=true;
            if (findCategory(ID,name))  {
                check =false;
                System.out.println("Name and ID cannot be duplicated");
            }
        } while (!check);
        Category category = new Category(ID,name);
        list.add(category);
    }

    public void updateCategory() {
        System.out.print("Enter the ID to be updated: ");
        String ID = scanner.nextLine();
        if ( findCategory(ID) ) {
            System.out.println("This category does not exist!");
        } else {
            int choice;
            do {
                System.out.println("===UPDATE OR DELETE===");
                System.out.println("1. Update");
                System.out.println("2. Delete");
                System.out.println("3. Back to main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:{
                        System.out.println("Just press ENTER. The information won't be changed");
                        System.out.print("Enter the new name of this category: ");
                        String name = scanner.nextLine();
                        if (!name.equals("")) {
                            for (Category category:list) {
                                if (category.getID().equals(ID))
                                    category.setName(name);
                            }
                        }
                        break;
                    }

                    case 2:{
                        System.out.println("Do you want to delete this category(Yes/No)? ");
                        System.out.print("Answer: ");
                        String option = scanner.nextLine();
                        if (option.equals("Yes")) {
                            list.remove(getCategory(ID));
                        }
                        System.out.println("====DELETE SUCCESSFULLY====");
                        break;
                    }
                }
            } while (choice!=3);
        }
    }

    public boolean findCategory(String ID, String name) {
        for (Category category: list) {
            if (category.getID().equals(ID) || category.getName().equals(name))
                return true;
        }
        return false;
    }

    public boolean findCategory(String ID) {
        for (Category category: list) {
            if (category.getID().equals(ID))
                return false;
        }
        return true;
    }

    public Category getCategory(String ID) {
        for (Category category: list) {
            if (category.getID().equals(ID))
                return category;
        }
        return null;
    }
}

