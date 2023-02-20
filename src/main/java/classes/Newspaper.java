package classes;

import java.time.LocalDate;

public class Newspaper extends Item {
    private String publisher;
    private LocalDate latestRelease;
    public Newspaper(String name, String publisher, LocalDate latestRelease){
        id = Item.getCount();
        this.name = name;
        this.publisher = publisher;
        this.latestRelease = latestRelease;
    }
    public Newspaper(String name, String publisher, LocalDate latestRelease, int amountAvailable, int amountRented){
        id = Item.getCount();
        this.name = name;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
        this.publisher = publisher;
        this.latestRelease = latestRelease;
    }
}
