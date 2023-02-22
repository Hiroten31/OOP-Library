package classes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name, surname, userID;
    private final LocalDate joinDate;
    private List<LocalDate> dateOfRenting = new ArrayList<>();
    private Integer phoneNumber;
    private List<Item> ItemsRented = new ArrayList<>();
    static List<User> Users = new ArrayList<>();
    public User(String name, String surname, LocalDate joinDate){
        this.name = name;
        this.surname = surname;
        this.joinDate = joinDate;
        userID = "" + name.charAt(0) + surname.charAt(0) + joinDate.getYear() + joinDate.getMonth() + joinDate.getDayOfMonth();
    }
    public User(String name, String surname, LocalDate joinDate, Integer phoneNumber){
        this.name = name;
        this.surname = surname;
        this.joinDate = joinDate;
        this.phoneNumber = phoneNumber;
        userID = phoneNumber.toString();
        Users.add(this);
    }
    public void setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        userID = phoneNumber.toString();
    }
    public String getUserID() {
        return userID;
    }
    public void rentsItem(Item item){
        ItemsRented.add(item);
        dateOfRenting.add(LocalDate.of(2022, Month.OCTOBER, ((phoneNumber%10)*item.getId())%28));
    }
    public void returnsItem(Item item){
        dateOfRenting.remove(ItemsRented.indexOf(item));
        ItemsRented.remove(item);
    }
    public String getFullName(){
        return name+" "+surname;
    }
    public List<Item> getRentedItems(){
        return ItemsRented;
    }
    public static User getUserById(String memberID){
        for (User user:Users) {
            if(user.getUserID().equals(memberID)){
                return user;
            }
        }
        return null;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public static List<User> getUserList(){
        return Users;
    }
    public List<LocalDate> getDateOfRenting(){
        return dateOfRenting;
    }
}
