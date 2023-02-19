package classes;

public abstract class Item {
    private static int count;
    int id, amountAvailable, amountRented;
    String name;
    public static int getCount() {
        return count;
    }
    Item() {
        ++count;
    }

    /*
    super() which cancels 'id = Item.getCount();' in kid classes, so I am disabling it.

    Item(String name, int amountAvailable, int amountRented){
        this.name = name;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
    }*/
}
