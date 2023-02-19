package classes;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Tworzenie obiektow
        //Dodanie ich do listy
        Book szachy = new Book("Nazwa", "autor", "publiszer", "description");
        Book szaszki = new Book("Nazwa", "autor", "publiszer", "description1", 10, 10);
        Book szaszy = new Book("Nazwa", "autor", "publiszer", "description");
        Newspaper wyborcza = new Newspaper("wyborcza","ale jaja", LocalDate.of(2018, 7, 20), 10, 10);
        Publication naukowa = new Publication("ale jaja", "edek", "jaja hehe", 10, 10);
        System.out.println("szachy.id: " + szachy.id);
        System.out.println("szaszki.id: " + szaszki.id);
        System.out.println("szaszy.id: " + szaszy.id);
        System.out.println("wyborcza.id: " + wyborcza.id);
        System.out.println("naukowa.id: " + naukowa.id);
        System.out.println("Item count: " + Item.getCount());
    }
}