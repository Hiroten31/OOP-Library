package classes;

public abstract class Item {
    static int count;
    int id;

    Item() {
        id = count++;
    }
}
