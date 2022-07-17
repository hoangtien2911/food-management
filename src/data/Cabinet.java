package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author Hoang-Tien | fb/htmsyunh/ Version2 2-10-2021
 */
public class Cabinet {

    private ArrayList<Food> foodList = new ArrayList();

    public void addFood() {
        String id, name, type, fileName;
        int place;
        double weight;
        LocalDate expiredDay;
        int pos;
        do {
            id = MyToys.getID("Input ID(FXXXX, X stands for digit): ",
                    "Please input ID again with correct format!!!", "[F|f]\\d{4}$");
            pos = searchFoodByIDForInput(id);
            if (pos >= 0) {
                System.out.println("The food id already exists."
                        + " Input another one!");
            }
        } while (pos != -1);

        name = MyToys.getString("Input name of food: ",
                "Please input again name of food!");

        weight = MyToys.getDouble("Input weight of food(0,001 - 10 kg): ",
                "Please input weight of food again!", 0.001, 10);

        type = MyToys.getString("Input type of food: ",
                "Please input again type of food");

        place = MyToys.getInteger("Place (Choose number 1(Freezer); 2(Freezer Door); 3(Regular); 4(Door)): ",
                 "Please input again by a number you choose", 1, 4);

        expiredDay = MyToys.inputValidDate("Input expired day of food(yyyy-mm-dd): ");

        foodList.add(new Food(id, name, weight, type, place, expiredDay));
        System.out.println("Input new food successfully!!!");

        fileName = MyToys.getString("Input name of file(.dat) you want to save: ",
                "Please input name of file again");
        try {
            FileWriter fw = new FileWriter(fileName + ".dat");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Food x : foodList) {
                bw.write(x.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public int searchFoodByIDForInput(String id) {
        if (foodList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Food searchFoodByID(String id) {
        if (foodList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getId().equalsIgnoreCase(id)) {
                return foodList.get(i);
            }
        }
        return null;
    }

    public void searchFoodByID() {
        String id;
        id = MyToys.getID("Input ID you want to search(FXXXX, X stands for digit): ",
                "Please input ID again with correct format!!!", "[F|f]\\d{4}$");
        Food x = searchFoodByID(id);
        if (x == null) {
            System.out.println("No food found on the list");
        } else {
            System.out.println("Food is found. There is: ");
            String header = String.format("|%-5s|%-20s|%6s|%-10s|%5s|%-11s|",
                    "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIRED DAY");
            System.out.println(header);
            x.showListFood();
        }

    }

    public void removeAFoodByID() {
        String id;
        String yes = "yes", no = "no";
        String answer;
        id = MyToys.getID("Input id(FXXXX, X stands for a digit) you want to remove: ",
                "Please input ID again with correct format!", "^[F|f]\\d{4}$");
        int x = searchFoodByIDForInput(id);
        if (x == -1) {
            System.out.println("Food not found!");
        } else {
            System.out.println("Food is found. Food in the list before remove:");
            foodList.get(x).showListFood();
            answer = MyToys.getString("Do you want to remove food in the list?  ", "Please answer yes or no!!!");
            if (answer.equalsIgnoreCase(yes)) {
                foodList.remove(x);
                System.out.println("Food has been removed from the list");
            }
            if (answer.equalsIgnoreCase(no)) {
                System.out.println("Food will not be deleted!");
            }
        }

    }

    public void printFoodList() {
        if (foodList.isEmpty()) {
            System.out.println("Food list is empty! Nothing to print.");
        }
        for (int i = 0; i < foodList.size() - 1; i++) {
            for (int j = i + 1; j < foodList.size(); j++) {
                if (foodList.get(i).getExpiredDay().isBefore(foodList.get(j).getExpiredDay())) {
                    Food tmp = foodList.get(i);
                    foodList.set(i, foodList.get(j));
                    foodList.set(j, tmp);
                }
            }
        }
        String header = String.format("|%-5s|%-20s|%6s|%-10s|%5s|%-11s|",
                "ID", "NAME", "WEIGHT", "TYPE", "PLACE", "EXPIRED DAY");
        System.out.println(header);
        for (int i = 0; i < foodList.size(); i++) {
            foodList.get(i).showListFood();
        }
    }
}
