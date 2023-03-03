package classes;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -944824420716579638L;
    private String name, surname, userID;
    private Integer phoneNumber;
    private final LocalDate joinDate;
    private List<LocalDate> dateOfRenting = new ArrayList<>();
    private List<Item> ItemsRented = new ArrayList<>();
    static ArrayList<User> Users = new ArrayList<>();
    private static int monthsForFree;
    private static double costPerDayOfDelay;
    public User(String name, String surname, Integer phoneNumber){
        this.name = name;
        this.surname = surname;
        this.joinDate = LocalDate.now();
        this.phoneNumber = phoneNumber;
        userID = phoneNumber.toString();
        Users.add(this);
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFullName(){
        return name+" "+surname;
    }
    public String getUserID() {
        return userID;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        userID = phoneNumber.toString();
    }
    public LocalDate getJoinDate() {
        return joinDate;
    }
    public List<LocalDate> getDateOfRenting(){
        return dateOfRenting;
    }
    public double getCost(int i){
        return DAYS.between(getDateOfRenting().get(i).plusMonths(monthsForFree), LocalDate.now())*costPerDayOfDelay;
    }
    public LocalDate getDateOfReturning(int i){
        return getDateOfRenting().get(i).plusMonths(monthsForFree);
    }
    public List<Item> getRentedItems(){
        return ItemsRented;
    }
    public static ArrayList<User> getUserList(){
        return Users;
    }
    public static void setUsers(ArrayList<User> users){
        Users = users;
    }
    public static int getMonthsForFree(){
        return monthsForFree;
    }
    public static void setMonthsForFree(int i){
        monthsForFree = i;
    }
    public static double getCostPerDayOfDelay(){
        return costPerDayOfDelay;
    }
    public static void setCostPerDayOfDelay(double i){
        costPerDayOfDelay = i;
    }
    public void rentsItem(Item item){
        ItemsRented.add(item);
        dateOfRenting.add(LocalDate.of(2022, Month.OCTOBER, ((phoneNumber%10)*item.getId())%28));
    }
    public void returnsItem(Item item){
        dateOfRenting.remove(ItemsRented.indexOf(item));
        ItemsRented.remove(item);
    }
}
