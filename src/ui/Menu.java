
package ui;

import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author Hoang-Tien | fb/htmsyunh/
 * Version2 2-10-2021
 */
public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String option) {
        optionList.add(option);
    }
    
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in menu");
            return;
        }
        System.out.println("-----------------------------");
        System.out.println("Welcome to " + menuTitle);
        System.out.println("Select the options below:");
        for (String x : optionList) {
            System.out.println(x);
        }
    }
    
    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Your choice 1..." + maxOption + ": ";
        String errorMsg = "Please choice 1..." + maxOption + "!";
        int choice = MyToys.getInteger(inputMsg, errorMsg, 1, maxOption);
        return choice;
    }
    
}
