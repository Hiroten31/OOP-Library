package classes;

public class Book extends Item {
    private String author, publisher, description;
    public Book(String name, String author, String publisher, String description){
        id = Item.getCount();
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
    }
    public Book(String name, String author, String publisher, String description, int amountAvailable, int amountRented){
        id = Item.getCount();
        this.name = name;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
    }
}
