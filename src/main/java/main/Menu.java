package main;

import classes.Item;
import classes.User;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static void start(){
        System.out.println("> Library system <\n1. Database\n2. Renting\n3. Returning\n4. Register new member\n\n0. Exit");
        String option = scanner.nextLine();
        if(option.charAt(0) == '1')
            Database();
        else if(option.charAt(0) == '2')
            Renting();
        else if(option.charAt(0) == '3')
            Returning();
        else if(option.charAt(0) == '4')
            Register();
        else if(option.charAt(0) == '0'){
            Exit();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n\n");
            start();
        }
    }
    static int Exit(){
        return 0;
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
    static void SearchForItem(){
        System.out.println("\n\n> Search for items <\n1. By ID\n2. By name\n3. By member ID\n0. Back");
        String option = scanner.nextLine();
        if(option.charAt(0) == '1'){
            System.out.println("\n\n> Search for item by ID <\nID: ");
            int searchID = scanner.nextInt();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item:Item.getItemList()) {
                if (searchID == item.getId()) {
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
                    System.out.println("Rented by:");
                    System.out.printf("%35s %25s\n", "FULL NAME", "DATE OF RENTING");
                    for (int i = 0; i < item.getRentedByUserID().size(); i++)
                        System.out.printf("%35s %25s\n", item.getRentedByUserID().get(i).getFullName(), item.getRentedByUserID().get(i).getDateOfRenting().get(item.getRentedByUserID().get(i).getRentedItems().indexOf(item)));

                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '2'){
            System.out.println("\n\n> Search for items by name <\nName: ");
            String searchName = scanner.nextLine();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item:Item.getItemList()) {
                if(searchName.equals(item.getName())) {
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
                    System.out.println("Rented by:");
                    System.out.printf("%35s %25s\n", "FULL NAME", "DATE OF RENTING");
                    for(int i=0; i<item.getRentedByUserID().size(); i++)
                        System.out.printf("%35s %25s\n", item.getRentedByUserID().get(i).getFullName(), item.getRentedByUserID().get(i).getDateOfRenting().get(item.getRentedByUserID().get(i).getRentedItems().indexOf(item)));

                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '3'){
            System.out.println("\n\n> Search for items by member ID <\nMember ID: ");
            String memberID = scanner.nextLine();
            System.out.printf("%5s %-150s %15s %5s\n", "ID", "NAME", "DATE OF RENTING", "ID");
            for (User user:User.getUserList()) {
                if(user.getUserID().equals(memberID)){
                    for(int i=0; i<user.getRentedItems().size(); i++)
                        System.out.printf("%5s %-150s %15s %5s\n", user.getRentedItems().get(i).getId(), user.getRentedItems().get(i).getName(), user.getDateOfRenting().get(i), user.getRentedItems().get(i).getId());
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
        System.out.println("\n\n> Browse through items <\n1. By type\n2. Less than amount available\n3. More than amount rented\n4. Display all\n0. Back");
        String option = scanner.nextLine();
        if(option.charAt(0) == '1') {
            System.out.println("\n\n> Browse through items by type <\nType: ");
            String type = scanner.nextLine();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item : Item.getItemList()) {
                if (item.getClass().getSimpleName().equals(type))
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            BrowseThroughItems();
        }
        else if(option.charAt(0) == '2') {
            System.out.println("\n\n> Browse through items with less than amount available <\nAmount available: ");
            int amountAvailable = scanner.nextInt();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item:Item.getItemList()) {
                if (item.getAmountAvailable()<=amountAvailable)
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            scanner.nextLine();
            BrowseThroughItems();
        }
        else if(option.charAt(0) == '3') {
            System.out.println("\n\n> Browse through items with more than amount rented <\nAmount rented: ");
            int amountRented = scanner.nextInt();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item:Item.getItemList()) {
                if (item.getAmountRented()>=amountRented)
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            scanner.nextLine();
            BrowseThroughItems();
        }
        else if(option.charAt(0) == '4'){
            System.out.printf("\n%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for (Item item:Item.getItemList()) {
                System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            BrowseThroughItems();
        }
        else if(option.charAt(0) == '0'){
            Database();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            BrowseThroughItems();
        }

    }
    static void SearchForMember(){
        System.out.println("\n\n> Search for member <\n1. By ID\n2. By full name\n3. By phone number\n4. All\n0. Back");
        String option = scanner.nextLine();
        if(option.charAt(0) == '1'){
            System.out.println("\n\n> Search for member by ID <\nMember ID: ");
            String memberID = scanner.nextLine();
            System.out.printf("%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
            for (User user:User.getUserList()) {
                if(user.getUserID().equals(memberID)) {
                    System.out.printf("%10s %-35s %25s %10d\n", user.getUserID(), user.getFullName(), user.getJoinDate(), user.getPhoneNumber());
                    if(user.getRentedItems().size()>0) {
                        System.out.println("Books rented:");
                        System.out.printf("%10s %-150s %15s %10s\n", "ID", "NAME", "DATE OF RENTING", "ID");
                        for (int i = 0; i < user.getRentedItems().size(); i++)
                            System.out.printf("%10s %-150s %15s %10s\n", user.getRentedItems().get(i).getId(), user.getRentedItems().get(i).getName(), user.getDateOfRenting().get(i), user.getRentedItems().get(i).getId());
                        System.out.printf("\n%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
                    }
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForMember();
        }
        else if(option.charAt(0) == '2'){
            System.out.println("\n\n> Search for member by full name <\nFull name: ");
            String fullName = scanner.nextLine();
            System.out.printf("%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
            for (User user:User.getUserList()) {
                if(user.getFullName().equals(fullName)) {
                    System.out.printf("%10s %-35s %25s %10d\n", user.getUserID(), user.getFullName(), user.getJoinDate(), user.getPhoneNumber());
                    if(user.getRentedItems().size()>0) {
                        System.out.println("Books rented:");
                        System.out.printf("%10s %-150s %15s %10s\n", "ID", "NAME", "DATE OF RENTING", "ID");
                        for (int i = 0; i < user.getRentedItems().size(); i++)
                            System.out.printf("%10s %-150s %15s %10s\n", user.getRentedItems().get(i).getId(), user.getRentedItems().get(i).getName(), user.getDateOfRenting().get(i), user.getRentedItems().get(i).getId());
                        System.out.printf("\n%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
                    }
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForMember();
        }
        else if(option.charAt(0) == '3'){
            System.out.println("\n\n> Search for member by phone number <\nPhone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.printf("%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
            for (User user:User.getUserList()) {
                if(user.getPhoneNumber().toString().equals(phoneNumber)){
                    System.out.printf("%10s %-35s %25s %10d\n", user.getUserID(), user.getFullName(), user.getJoinDate(), user.getPhoneNumber());
                    if(user.getRentedItems().size()>0) {
                        System.out.println("Books rented:");
                        System.out.printf("%10s %-150s %15s %10s\n", "ID", "NAME", "DATE OF RENTING", "ID");
                        for (int i = 0; i < user.getRentedItems().size(); i++)
                            System.out.printf("%10s %-150s %15s %10s\n", user.getRentedItems().get(i).getId(), user.getRentedItems().get(i).getName(), user.getDateOfRenting().get(i), user.getRentedItems().get(i).getId());
                        System.out.printf("\n%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
                    }
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForMember();
        }
        else if(option.charAt(0) == '4'){
            System.out.printf("%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
            for (User user:User.getUserList())
                    System.out.printf("%10s %-35s %25s %10d\n", user.getUserID(), user.getFullName(), user.getJoinDate(), user.getPhoneNumber());
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForMember();
        }
        else if(option.charAt(0) == '0'){
            Database();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            SearchForMember();
        }
    }
    static void ManageItems(){

    }
}
