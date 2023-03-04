package classes;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = -8254487033175773570L;

    private static int count;
    private final int id;
    protected int amountAvailable = 0, amountRented = 0;
    protected String name;
    private final List<User> rentedByUsersID = new ArrayList<>();
    static ArrayList<Item> Items = new ArrayList<>();

    //Method used to make unique ID for every single item created and adding it to a list.
    Item() {
        ++count;
        this.id = count;
        Items.add(this);
    }

    //Getters and Setters
    public int getId(){
        return id;
    }

    public int getAmountAvailable(){
        return amountAvailable;
    }

    public int getAmountRented(){
        return amountRented;
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
            count = items.get(items.size()-1).getId(); //It sets our static count variable to right value, very important due to lack of serialization of static variables.
    }

    public List<User> getRentedByUserID(){
        return rentedByUsersID;
    }

    //Methods
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

    //Simple interface method, which is used to print out all the unique information of an item.
    public abstract void getInfo();
}
