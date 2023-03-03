package classes;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = -8254487033175773570L;
    private static int count;
    protected int id, amountAvailable = 0, amountRented = 0;
    protected String name;
    List<User> rentedByUsersID = new ArrayList<>();
    static ArrayList<Item> Items = new ArrayList<>();
    Item() {
        ++count;
        this.id = count;
        Items.add(this);
    }
    public int getId(){
        return id;
    }
    public int getAmountAvailable(){
        return amountAvailable;
    }
    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }
    public int getAmountRented(){
        return amountRented;
    }
    public void setAmountRented(int amountRented) {
        this.amountRented = amountRented;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static ArrayList<Item> getItemList(){
        return Items;
    }
    public static void setItems(ArrayList<Item> items){
        Items = items;
        if(items.size()!=0)
            count = items.get(items.size()-1).getId();
    }
    public List<User> getRentedByUserID(){
        return rentedByUsersID;
    }
    public void rentItem(User user){
        if(amountAvailable>0) {
            amountAvailable--;
            amountRented++;
            rentedByUsersID.add(user);
            user.rentsItem(this);
        } else {
            System.out.println("You can't rent this item! There is not a single one available!");
        }
    }
    public void returnItem(User user){
        if(amountRented>0) {
            amountAvailable++;
            amountRented--;
            rentedByUsersID.remove(user);
            user.returnsItem(this);
        } else {
            System.out.println("You can't return this item! There is not a single one rented!");
        }
    }
    public abstract void getInfo();
}
