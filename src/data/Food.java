
package data;

import java.time.LocalDate;

/**
 *
 * @author Hoang-Tien | fb/htmsyunh/
 * Version2 2-10-2021
 */
public class Food implements Comparable<Food> {

    private String id;
    private String name;
    private double weight;
    private String type;
    private int place;
    private LocalDate expiredDay;

    public Food(String id, String name, double weight, String type, int place, LocalDate expiredDay) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDay = expiredDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public LocalDate getExpiredDay() {
        return expiredDay;
    }

    public void setExpiredDay(LocalDate expiredDay) {
        this.expiredDay = expiredDay;
    }

    // So sánh ID mặc định trên Food
    @Override
    public int compareTo(Food that) {
        return this.id.compareToIgnoreCase(that.id);
    }

    @Override
    public String toString() {
        return String.format("|%-5s|%-20s|%6.1f|%-10s|%5s|%-11s|\n",
                                    id, name, weight, type, place, expiredDay);
    }
    
    
    
    public void showListFood() {
        System.out.printf("|%-5s|%-20s|%6.1f|%-10s|%5s|%-11s|\n",
                                    id, name, weight, type, place, expiredDay);
    }
}
