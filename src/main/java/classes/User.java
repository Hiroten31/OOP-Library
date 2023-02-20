package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name, surname, userID;
    private final LocalDate joinDate;
    private static List<LocalDate> dateOfRenting = new ArrayList<>();
    private Integer phoneNumber;
    private List<Integer> ItemsRented = new ArrayList<>();
    private static List<User> Users = new ArrayList<>();
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
        userID = phoneNumber.toString();
    }
    public void setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        userID = phoneNumber.toString();
    }
    public String getUserID() {
        return userID;
    }
    public void rentsItem(int id){
        ItemsRented.add(id);
        dateOfRenting.add(LocalDate.now());
    }
    public void returnsItem(Integer id){
        dateOfRenting.remove(ItemsRented.indexOf(id));
        ItemsRented.remove(id);
    }
    public String getFullName(){
        return name+" "+surname;
    }
    public List<Integer> getRentedItems(){
        return ItemsRented;
    }
    /*public static LocalDate findDateOfRenting(int itemIndex){
        return dateOfRenting.get(itemIndex);
    }*/
}
