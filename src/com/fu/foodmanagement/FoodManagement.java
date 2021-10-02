
package com.fu.foodmanagement;

import data.Cabinet;
import ui.Menu;

/**
 *
 * @author Hoang-Tien | fb/htmsyunh/
 * Version2 2-10-2021
 */
public class FoodManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Food Management - @ 2021 by <SE160239 - Phạm Hoàng Tiến>");
        menu.addNewOption("1. Add a new food");
        menu.addNewOption("2. Search a food by name");
        menu.addNewOption("3. Remove the food by ID");
        menu.addNewOption("4. Print the food list in the descending order of expired date");
        menu.addNewOption("5. Quit");
        Cabinet cage = new Cabinet();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch(choice) {
                case 1:
                    System.out.println("You are preparing to input food");
                    cage.addFood();
                    break;
                case 2:
                    System.out.println("You are required to input "
                            + "a book id to search.");
                    cage.searchFoodByID();
                    break;
                case 3:
                    System.out.println("You are required to input "
                            + "a food id to remove.");
                    cage.removeAFoodByID();
                    break;
                case 4:
                    System.out.println("You are required to print list of food.");
                    cage.printFoodList();
                    break;
                case 5:
                    System.out.println("Bye bye, see you next time.");
                    break;
            }
                    
        } while (choice != 5);
    }

}
