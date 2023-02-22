package classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    private static int count;
    int id, amountAvailable, amountRented;
    String name;
    List<User> rentedByUsersID = new ArrayList<>();
    static List<Item> Items = new ArrayList<>();
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
        rentedByUsersID.add(user);
        user.rentsItem(this);
    }
    public void returnItem(User user){
        amountAvailable++;
        amountRented--;
        rentedByUsersID.remove(user);
        user.returnsItem(this);
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
    public List<User> getRentedByUserID(){
        return rentedByUsersID;
    }

    /*super() which cancels 'id = Item.getCount();' in kid classes, so I am disabling it.
    Item(String name, int amountAvailable, int amountRented){
        this.name = name;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
    }*/
}
