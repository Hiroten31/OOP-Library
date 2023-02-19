package classes;

import java.time.LocalDate;

public class Newspaper extends Item {
    String publisher;
    LocalDate latestRelease;
    Newspaper(){
        id = count++;
    }
}
