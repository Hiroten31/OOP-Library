package classes;

public class Book extends Item {
    private String author, publisher, description;
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

    public Book(String name, String author, String publisher, String description, int amountAvailable, int amountRented){
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        if(amountAvailable>=0) {
            this.amountAvailable = amountAvailable;
        } else {
            System.out.println("You gave an incorrect number! Amount available will be set to 0.");
            this.amountAvailable = 0;
        }
        if(amountRented>=0){
            this.amountRented = amountRented;
        } else {
            System.out.println("You gave an incorrect number! Amount rented will be set to 0.");
            this.amountRented = 0;
        }
    }
    @Override
    public void getInfo(){
        System.out.println("Book: " + getName());
        System.out.println("\tAuthor: " + author);
        System.out.println("\tPublisher: " + publisher);
        System.out.println("\tDescription: " + description);
        System.out.println();
    }
}
