package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    private static int count;
    int id, amountAvailable, amountRented;
    String name;
    List<String> rentedByUsersID = new ArrayList<>();
    private static List<Item> Items = new ArrayList<>();
    static int getCount() {
        return count;
    }
    Item() {
        ++count;
        Items.add(this);
    }
    public void rentItem(User user){
        amountAvailable--;
        amountRented++;
        rentedByUsersID.add(user.getUserID());
        user.rentsItem(this.id);
    }
    public void returnItem(User user){
        amountAvailable++;
        amountRented--;
        rentedByUsersID.remove(user.getUserID());
        user.returnsItem(this.id);
    }
    public static List<Item> getItemList(){
        return Items;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getAmountAvailable(){
        return amountAvailable;
    }
    public int getAmountRented(){
        return amountRented;
    }
    public List<String> getRentedByUserID(){
        return rentedByUsersID;
    }

    /*super() which cancels 'id = Item.getCount();' in kid classes, so I am disabling it.
    Item(String name, int amountAvailable, int amountRented){
        this.name = name;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
    }*/
}
