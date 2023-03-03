package classes;

import java.time.LocalDate;

public class Newspaper extends Item {
    private String publisher;
    private LocalDate Release;
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public LocalDate getRelease() {
        return Release;
    }

    public void setRelease(LocalDate release) {
        Release = release;
    }

    public Newspaper(String name, String publisher, LocalDate Release, int amountAvailable, int amountRented) {
        this.name = name;
        this.publisher = publisher;
        this.Release = Release;
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
        System.out.println("Newspaper: " + getName());
        System.out.println("\tPublisher: " + publisher);
        System.out.println("\tLatest Release: " + Release);
        System.out.println();
    }
}
