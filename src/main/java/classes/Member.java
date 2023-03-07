package classes;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Member implements Serializable {
    @Serial
    private static final long serialVersionUID = -944824420716579638L;

    private String name, surname, memberID;
    private Integer phoneNumber;
    private final LocalDate joinDate;
    private final List<LocalDate> dateOfRenting = new ArrayList<>();
    private final List<Item> ItemsRented = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    private static int monthsForFree;
    private static double costPerDayOfDelay;

    //Basic method to create an object
    public Member(String name, String surname, Integer phoneNumber){
        this.name = name;
        this.surname = surname;
        this.joinDate = LocalDate.now();
        this.phoneNumber = phoneNumber;
        memberID = phoneNumber.toString();
        members.add(this);
    }

    //Getters and Setters
    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMemberID() {
        return memberID;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        memberID = phoneNumber.toString();
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public List<LocalDate> getDateOfRenting(){
        return dateOfRenting;
    }

    public List<Item> getItemsRented(){
        return ItemsRented;
    }

    public static ArrayList<Member> getMemberList(){
        return members;
    }

    public static void setMembers(ArrayList<Member> members){
        Member.members = members;
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

    //Methods
    public String getFullName(){
        return name+" "+surname;
    }

    public LocalDate getDateOfReturning(int i){
        return getDateOfRenting().get(i).plusMonths(monthsForFree);
    }

    public double getCost(int i){
        if(getDateOfRenting().get(i).plusMonths(monthsForFree).isBefore(LocalDate.now())){
            return DAYS.between(getDateOfRenting().get(i).plusMonths(monthsForFree), LocalDate.now())*costPerDayOfDelay;
        }
        return 0;
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
