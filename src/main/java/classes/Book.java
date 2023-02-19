package classes;

public class Book extends Item {
    String author, publisher, description;

    Book() {
        id = count++;
    }
}
