package classes;

public class Publication extends Item {
    private String topic, author;
    public Publication(String name, String author, String topic){
        id = Item.getCount();
        this.name = name;
        this.author = author;
        this.topic = topic;
    }
    public Publication(String name, String author, String topic, int amountAvailable, int amountRented){
        id = Item.getCount();
        this.name = name;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
        this.author = author;
        this.topic = topic;
    }
}
