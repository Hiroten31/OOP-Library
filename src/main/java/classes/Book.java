package classes;

public class Book extends Item {

    private String author, publisher, description;

    //Basic method to create an object
    public Book(String name, String author, String publisher, String description, int amountAvailable, int amountRented){
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
    }

    //Getters and Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Implementation of the method from Item.class
    @Override
    public void getInfo(){
        System.out.println("Book: " + getName());
        System.out.println("\tAuthor: " + author);
        System.out.println("\tPublisher: " + publisher);
        System.out.println("\tDescription: " + description);
        System.out.println();
    }
}
