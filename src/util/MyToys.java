
package util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 *
 * @author Hoang-Tien | fb/htmsyunh/
 * Version2 2-10-2021
 */
public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        do {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.isEmpty() || id.length() == 0 || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        } while (true);

    }
    // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
    public static boolean isValidDate(String date) {
        boolean valid;
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
    
    public static LocalDate inputValidDate(String inputMsg) {
        String inputDate;
        LocalDate date = null;
        do {
            System.out.print(inputMsg);
            inputDate = sc.nextLine().trim();
            if (!isValidDate(inputDate))
                System.out.println("Invalid Date");
            else {
                date = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                if (date.isBefore(LocalDate.now())) 
                    System.out.println("Please don't type in date in the past, expired food must be after the current time.");
            }
        } while (!isValidDate(inputDate) || date.isBefore(LocalDate.now()));
        return LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
        
    }

    public static String getString(String inputMsg, String errorMsg) {
        do {
            System.out.print(inputMsg);
            String n = sc.nextLine().trim().toUpperCase();
            if (n.isEmpty() || n.length() == 0) {
                System.out.println(errorMsg);
            } else {
                return n;
            }
        } while (true);

    }

    public static double getDouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        do {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);

    }

    public static int getInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        do {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);

    }
    
    //Test ID
    //Shift + f6 for run
    public static void main(String[] args) {
        String id = getID("Input ID(with format FXXXX, X stands for a digit): ",
                                    "Please input again with true format", "[F|f]\\d{4}$");
        System.out.println("Your ID: " + id);
    }
}
