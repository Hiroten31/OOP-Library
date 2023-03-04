package classes;

import java.time.LocalDate;

public class Newspaper extends Item {

    private String publisher;
    private LocalDate release;

    //Basic method to create an object
    public Newspaper(String name, String publisher, LocalDate release, int amountAvailable, int amountRented) {
        this.name = name;
        this.publisher = publisher;
        this.release = release;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
    }

    //Getters and Setters
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public LocalDate getRelease() {
        return release;
    }
    public void setRelease(LocalDate release) {
        this.release = release;
    }

    //Implementation of the method from Item.class
    @Override
    public void getInfo(){
        System.out.println("Newspaper: " + getName());
        System.out.println("\tPublisher: " + publisher);
        System.out.println("\tLatest Release: " + release);
        System.out.println();
    }
}
