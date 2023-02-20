package main;

import classes.Item;
import classes.User;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static void start(){
        System.out.println("Library system.\n1. Database\n2. Renting\n3. Returning\n4. Register new member\n\n0. Exit");
        String option = scanner.nextLine();
        if(option.charAt(0) == '1')
            Database();
        else if(option.charAt(0) == '2')
            Renting();
        else if(option.charAt(0) == '3')
            Returning();
        else if(option.charAt(0) == '4')
            Register();
        else if(option.charAt(0) == '0')
            Exit();
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n\n\n");
            start();
        }
    }
    static void Database(){
        System.out.println("\n\n> Database <\n1. Search for item\n2. Browse through items\n3. Search for member\n4. Add/delete an item\n0. Back");
        String option = scanner.nextLine();
        if(option.charAt(0) == '1')
            SearchForItem();
        else if(option.charAt(0) == '2')
            BrowseThroughItems();
        else if(option.charAt(0) == '3')
            SearchForMember();
        else if(option.charAt(0) == '4')
            ManageItems();
        else if(option.charAt(0) == '0'){
            System.out.println("\n\n");
            start();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            Database();
        }
    }
    static void Renting(){

    }
    static void Returning(){

    }
    static void Register(){

    }
    static int Exit(){
        return 0;
    }
    static void SearchForItem(){
        System.out.println("\n\n> Search for item <\n1. By ID\n2. By Name\n3. By member ID\n0. Back");
        String option = scanner.nextLine();
        if(option.charAt(0) == '1'){
            System.out.println("\n\n> Search for item by ID <\nID: ");
            int searchID = scanner.nextInt();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item:Item.getItemList()) {
                if(searchID == item.getId()) {
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '2'){
            System.out.println("\n\n> Search for item by Name <\nName: ");
            String searchName = scanner.nextLine();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item:Item.getItemList()) {
                if(searchName.equals(item.getName())) {
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '3'){
            System.out.println("\n\n> Search for item by member ID <\nMember ID: ");
            String memberID = scanner.nextLine();
            System.out.printf("%5s %-150s %10s %5s\n", "ID", "NAME", "DATE OF RENTING", "ID");
            for (Item item:Item.getItemList()) {
                if(item.getRentedByUserID().contains(memberID)) {
                    /*System.out.printf("%5s %-150s %10s %5s\n", item.getId(), item.getName(), User.findDateOfRenting(Item.getItemList().indexOf(item)), item.getId());*/
                    System.out.printf("%5s %-150s %10s %5s\n", item.getId(), item.getName(), LocalDate.now(), item.getId());
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '0')
            Database();
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            SearchForItem();
        }
    }
    static void BrowseThroughItems(){
        System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
        for (Item item:Item.getItemList()) {
            System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
        }
        System.out.println("\n\nClick anything to return...");
        scanner.nextLine();
        Database();
    }
    static void SearchForMember(){

    }
    static void ManageItems(){

    }
}
