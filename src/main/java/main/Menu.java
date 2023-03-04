package main;

import classes.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    static void Start(){
        System.out.println("\n\n> Library system <\n1. Database\n2. Renting\n3. Returning\n4. Register new member\n\n0. Exit");
        String option = notBlank();
        if(option.charAt(0) == '1')
            Database();
        else if(option.charAt(0) == '2')
            Renting();
        else if(option.charAt(0) == '3')
            Returning();
        else if(option.charAt(0) == '4')
            Register();
        else //noinspection StatementWithEmptyBody
            if(option.charAt(0) == '0'){}
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n\n");
            Start();
        }
    }

    //Method accessed from Start()
    static void Database(){
        System.out.println("\n\n> Database <\n1. Search for item\n2. Browse through items\n3. Search for member\n4. Get detailed information about an item\n5. Manage items and users\n\n0. Back");
        String option = notBlank();
        if(option.charAt(0) == '1')
            SearchForItem();
        else if(option.charAt(0) == '2')
            BrowseThroughItems();
        else if(option.charAt(0) == '3')
            SearchForMember();
        else if(option.charAt(0) == '4')
            GetInfo();
        else if(option.charAt(0) == '5')
            ManageItems();
        else if(option.charAt(0) == '0'){
            System.out.println("\n\n");
            Start();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            Database();
        }
    }

    static void Renting(){
        System.out.println("\n\n> Renting an item <\nItem ID: ");
        int itemID = scanner.nextInt();
        scanner.nextLine();
        for(Item item : Item.getItemList()){
            if(item.getId() == itemID){
                if(item.getAmountAvailable()>0) {
                    System.out.println("Member ID: ");
                    String memberID = scanner.nextLine();
                    for(User user : User.getUserList()){
                        if(user.getUserID().equals(memberID)) {
                            System.out.println("User " + user.getFullName() + " is renting an item " + item.getId() + ". " + item.getName());
                            item.rentItem(user);
                            break;
                        }
                    }
                }
                else {
                    System.out.println("You can't rent this item! There is not a single one available!");
                }
                break;
            }
        }
        System.out.println("\n\nClick anything to return...");
        scanner.nextLine();
        Start();
    }

    static void Returning(){
        System.out.println("\n\n> Returning an item <\nItem ID: ");
        int itemID = scanner.nextInt();
        scanner.nextLine();
        for(Item item : Item.getItemList()){
            if(item.getId() == itemID){
                if(item.getAmountRented()>0) {
                    System.out.println("Member ID: ");
                    String memberID = scanner.nextLine();
                    for(User user : User.getUserList()) {
                        if(user.getUserID().equals(memberID)) {
                            if(item.getRentedByUserID().contains(user)) {
                                System.out.println("User " + user.getFullName() + " is returning an item " + item.getId() + ". " + item.getName());
                                item.returnItem(user);
                            }
                            else {
                                System.out.println("This user didn't rented this item! Can't return.");
                            }
                            break;
                        }
                    }
                }
                else {
                    System.out.println("You can't return this item! There is not a single one rented!");
                }
                break;
            }
        }
        System.out.println("\n\nClick anything to return...");
        scanner.nextLine();
        Start();
    }

    static void Register(){
        System.out.println("\n\n> Register an User <");
        String name, surname;
        name = notBlank("Name: ");
        surname = notBlank("Surname: ");
        long phoneNumber;
        do {
            System.out.println("Phone number: ");
            phoneNumber = scanner.nextLong();
        } while(Long.toString(phoneNumber).length()!=9);
        scanner.nextLine();
        boolean check = true;
        for(User phoneCheck : User.getUserList()){ //This weird loop is necessary to check if phone number won't duplicate in database.
            if (phoneCheck.getPhoneNumber().equals((int) phoneNumber)) {
                check = false;
                break;
            }
        }
        if(check) {
            User user = new User(name, surname, (int) phoneNumber);
            System.out.println("New user: " + user.getFullName() + ", phone number: " + user.getPhoneNumber() + " have been successfully registered!");
        }
        else {
            System.out.println("You can't set phone number to " + phoneNumber + ", because it's already used!");
        }
        System.out.println("\n\nClick anything to return...");
        scanner.nextLine();
        Start();
    }

    //Methods accessed from Database()
    static void SearchForItem(){
        System.out.println("\n\n> Search for items <\n1. By ID\n2. By name\n3. By member ID\n\n0. Back");
        String option = notBlank();
        if(option.charAt(0) == '1'){
            System.out.println("\n\n> Search for item by ID <\nID: ");
            int searchID = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for(Item item : Item.getItemList()) {
                if (searchID == item.getId()) {
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
                    System.out.println("Rented by:");
                    System.out.printf("%35s %25s\n", "FULL NAME", "DATE OF RENTING");
                    for(int i = 0; i < item.getRentedByUserID().size(); i++)
                        System.out.printf("%35s %25s\n", item.getRentedByUserID().get(i).getFullName(), item.getRentedByUserID().get(i).getDateOfRenting().get(item.getRentedByUserID().get(i).getItemsRented().indexOf(item)));
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '2'){
            System.out.println("\n\n> Search for items by name <\nName: ");
            String searchName = scanner.nextLine();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for(Item item : Item.getItemList()) {
                if(searchName.equals(item.getName())) {
                    System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
                    System.out.println("Rented by:");
                    System.out.printf("%35s %25s\n", "FULL NAME", "DATE OF RENTING");
                    for(int i = 0; i < item.getRentedByUserID().size(); i++)
                        System.out.printf("%35s %25s\n", item.getRentedByUserID().get(i).getFullName(), item.getRentedByUserID().get(i).getDateOfRenting().get(item.getRentedByUserID().get(i).getItemsRented().indexOf(item)));
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '3'){
            System.out.println("\n\n> Search for items by member ID <\nMember ID: ");
            String memberID = scanner.nextLine();
            System.out.printf("%5s %-150s %15s %20s %10s %5s\n", "ID", "NAME", "DATE OF RENTING", "DATE OF RETURNING", "COST", "ID");
            for(User user : User.getUserList()) {
                if(user.getUserID().equals(memberID)){
                    for(int i = 0; i<user.getItemsRented().size(); i++)
                        System.out.printf("%5s %-150s %15s %20s %10.2f %5s\n", user.getItemsRented().get(i).getId(), user.getItemsRented().get(i).getName(), user.getDateOfRenting().get(i), user.getDateOfReturning(i), user.getCost(i), user.getItemsRented().get(i).getId());
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForItem();
        }
        else if(option.charAt(0) == '0'){
            Database();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            SearchForItem();
        }
    }

    static void BrowseThroughItems(){
        System.out.println("\n\n> Browse through items <\n1. By type\n2. Less than amount available\n3. More than amount rented\n4. Display all\n\n0. Back");
        String option = notBlank();
        if(option.charAt(0) == '1') {
            System.out.println("\n\n> Browse through items by type <\nType: (types: Book, Publication, Newspaper)");
            String type = scanner.nextLine();
            System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
            for(Item item : Item.getItemList()) {
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
            for(Item item : Item.getItemList()) {
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
            for(Item item : Item.getItemList()) {
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
            for(Item item : Item.getItemList()) {
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
        System.out.println("\n\n> Search for member <\n1. By ID\n2. By full name\n3. By phone number\n4. Display all\n\n0. Back");
        String option = notBlank();
        if(option.charAt(0) == '1'){
            System.out.println("\n\n> Search for member by ID <\nMember ID: ");
            String memberID = scanner.nextLine();
            System.out.printf("%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
            for(User user : User.getUserList()) {
                if(user.getUserID().equals(memberID)) {
                    System.out.printf("%10s %-35s %25s %10d\n", user.getUserID(), user.getFullName(), user.getJoinDate(), user.getPhoneNumber());
                    printItemsRented(user);
                    break;
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
            for(User user : User.getUserList()) {
                if(user.getFullName().equals(fullName)) {
                    System.out.printf("%10s %-35s %25s %10d\n", user.getUserID(), user.getFullName(), user.getJoinDate(), user.getPhoneNumber());
                    printItemsRented(user);
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
            for(User user : User.getUserList()) {
                if(user.getPhoneNumber().toString().equals(phoneNumber)){
                    System.out.printf("%10s %-35s %25s %10d\n", user.getUserID(), user.getFullName(), user.getJoinDate(), user.getPhoneNumber());
                    printItemsRented(user);
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            SearchForMember();
        }
        else if(option.charAt(0) == '4'){
            System.out.printf("%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
            for(User user : User.getUserList())
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

    static void GetInfo() {
        System.out.println("\n\n> Get detailed information about an item <\n1. By type\n2. By ID\n\n0. Back");
        String option = notBlank();
        if (option.charAt(0) == '1') {
            System.out.println("\n\n> Get detailed information about an item by type <\n1. Book\n2. Newspaper\n3. Publication");
            option = notBlank();
            if(option.charAt(0) == '1') {
                System.out.println("\n\n> Get detailed information about a Book <\n1. By author\n2. By publisher");
                option = notBlank();
                if(option.charAt(0) == '1'){
                    System.out.println("Author: ");
                    String author = scanner.nextLine();
                    for(Item item : Item.getItemList()){
                        if (item instanceof Book) {
                            if (((Book) item).getAuthor().equals(author))
                                item.getInfo();
                        }
                    }
                }
                else if(option.charAt(0) == '2'){
                    System.out.println("Publisher: ");
                    String publisher = scanner.nextLine();
                    for(Item item : Item.getItemList()){
                        if (item instanceof Book) {
                            if (((Book) item).getPublisher().equals(publisher))
                                item.getInfo();
                        }
                    }
                }
                else {
                    System.out.println("You had chose option out of possible outcomes. Try again!\n");
                }
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                GetInfo();
            }
            else if(option.charAt(0) == '2') {
                System.out.println("\n\n> Get detailed information about a Newspaper <\n1. By publisher\n2. Before date of release\n3. After date of release");
                option = notBlank();
                if(option.charAt(0) == '1'){
                    System.out.println("Publisher: ");
                    String publisher = scanner.nextLine();
                    for(Item item : Item.getItemList()){
                        if (item instanceof Newspaper) {
                            if (((Newspaper) item).getPublisher().equals(publisher))
                                item.getInfo();
                        }
                    }
                }
                else if(option.charAt(0) == '2') {
                    LocalDate date = getValidDate();
                    for(Item item : Item.getItemList()){
                        if (item instanceof Newspaper) {
                            if (((Newspaper) item).getRelease().isBefore(date))
                                item.getInfo();
                        }
                    }
                }
                else if(option.charAt(0) == '3') {
                    LocalDate date = getValidDate();
                    for(Item item : Item.getItemList()){
                        if (item instanceof Newspaper) {
                            if (((Newspaper) item).getRelease().isAfter(date))
                                item.getInfo();
                        }
                    }
                }
                else {
                    System.out.println("You had chose option out of possible outcomes. Try again!\n");
                }
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                GetInfo();
            }
            else if(option.charAt(0) == '3') {
                System.out.println("\n\n> Get detailed information about a Publication <\n1. By author\n2. By topic");
                option = notBlank();
                if(option.charAt(0) == '1'){
                    System.out.println("Author: ");
                    String author = scanner.nextLine();
                    for(Item item : Item.getItemList()){
                        if (item instanceof Publication) {
                            if (((Publication) item).getAuthors().contains(author))
                                item.getInfo();
                        }
                    }
                }
                else if(option.charAt(0) == '2'){
                    System.out.println("Topic: ");
                    String topic = scanner.nextLine();
                    for(Item item : Item.getItemList()){
                        if (item instanceof Publication) {
                            if (((Publication) item).getTopic().contains(topic))
                                item.getInfo();
                        }
                    }
                }
                else {
                    System.out.println("You had chose option out of possible outcomes. Try again!\n");
                }
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                GetInfo();
            }
            else {
                System.out.println("You had chose option out of possible outcomes. Try again!\n");
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            GetInfo();
        }
        else if (option.charAt(0) == '2'){
            System.out.println("\n\n> Get detailed information about an item by ID <\nItem ID: ");
            int searchID = scanner.nextInt();
            scanner.nextLine();
            for(Item item : Item.getItemList()) {
                if (searchID == item.getId()) {
                    item.getInfo();
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            GetInfo();
        }
        else if(option.charAt(0) == '0'){
            System.out.println("\n\n");
            Database();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            GetInfo();
        }
    }

    static void ManageItems(){
        System.out.println("\n\n> Manage items and users <\n1. Add an item\n2. Remove an item\n3. Change properties of an item\n4. Remove an user\n5. Change properties of an user\n6. Change general settings\n\n0. Back");
        String option = notBlank();
        if(option.charAt(0) == '1'){
            System.out.println("\n\n> Add an item to database <\n1. Book\n2. Newspaper\n3. Publication\n\n0. Back");
            option = notBlank();
            if(option.charAt(0)=='1'){
                System.out.println("\n\n> Add a Book to database <");
                String name, author, publisher, description;
                name = notBlank("Name: ");
                author = notBlank("Author: ");
                publisher = notBlank("Publisher: ");
                description = notBlank("Description: ");
                int amountAvailable;
                do{
                    System.out.println("Amount available: ");
                    amountAvailable = scanner.nextInt();
                } while(amountAvailable<0);
                scanner.nextLine();
                Book item = new Book(name, author, publisher, description, amountAvailable, 0);
                System.out.println("Successfully added " + item.getId() + ". " + item.getName() + " to database!");
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                ManageItems();
            }
            else if(option.charAt(0)=='2'){
                System.out.println("\n\n> Add a Newspaper to database <");
                String name, publisher;
                name = notBlank("Name: ");
                publisher = notBlank("Publisher: ");
                LocalDate date = getValidDate();
                int amountAvailable;
                do{
                    System.out.println("Amount available: ");
                    amountAvailable = scanner.nextInt();
                } while(amountAvailable<0);
                scanner.nextLine();
                Newspaper item = new Newspaper(name, publisher, date, amountAvailable, 0);
                System.out.println("Successfully added " + item.getId() + ". " + item.getName() + " to database!");
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                ManageItems();
            }
            else if(option.charAt(0)=='3'){
                System.out.println("\n\n> Add a Publication to database <");
                String name, topic, author;
                name = notBlank("Name: ");
                topic = notBlank("Topic: ");
                int amountAvailable;
                do{
                    System.out.println("Amount available: ");
                    amountAvailable = scanner.nextInt();
                } while(amountAvailable<0);
                scanner.nextLine();
                Publication item = new Publication(name, topic, amountAvailable, 0);
                int amountOfAuthors;
                do{
                    System.out.println("How many authors you want to add for that publication?");
                    amountOfAuthors = scanner.nextInt();
                } while(amountOfAuthors<0);
                scanner.nextLine();
                for(; amountOfAuthors>0; amountOfAuthors--) { //For loop to add right amount of authors to a Publication list.
                    author = notBlank("Author: ");
                    item.getAuthors().add(author);
                }
                System.out.println("Successfully added " + item.getId() + ". " + item.getName() + " to database!");
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                ManageItems();
            }
            else {
                System.out.println("\n\n");
                ManageItems();
            }
        }
        else if(option.charAt(0) == '2'){
            System.out.println("\n\n> Remove an item from database <\nItem ID: ");
            int itemID = scanner.nextInt();
            scanner.nextLine();
            for(Item item : Item.getItemList()) {
                if(item.getId() == itemID) {
                    if(item.getAmountRented() == 0) {
                        System.out.println("Are you sure you want to remove " + item.getId() + ". " + item.getName() + "?\nY / N");
                        option = notBlank();
                        if (option.charAt(0) == 'Y' || option.charAt(0) == 'y') {
                            System.out.println("\nItem " + item.getId() + ". " + item.getName() + " has been successfully deleted!");
                            Item.getItemList().remove(item); //Fixed ConcurrentModificationException by adding break, which also improves efficiency
                        }
                        else if (option.charAt(0) == 'N' || option.charAt(0) == 'n') {
                            System.out.println("\nYou declined deleting an item!");
                        }
                        else {
                            System.out.println("\nYou had chose option out of possible outcomes. Try again!\n");
                        }
                    }
                    else {
                        System.out.println("Can't delete an item! It is still rented by: ");
                        System.out.printf("%35s %25s\n", "FULL NAME", "DATE OF RENTING");
                        for(int j = 0; j < item.getRentedByUserID().size(); j++)
                            System.out.printf("%35s %25s\n", item.getRentedByUserID().get(j).getFullName(), item.getRentedByUserID().get(j).getDateOfRenting().get(item.getRentedByUserID().get(j).getItemsRented().indexOf(item)));
                    }
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            ManageItems();
        }
        else if(option.charAt(0) == '3'){
            System.out.println("\n\n> Change properties of an item <\nItem ID: ");
            int itemID = scanner.nextInt();
            scanner.nextLine();
            for(Item item : Item.getItemList()) {
                if (itemID == item.getId()) {
                    if (item instanceof Book) {
                        System.out.println("\n\nChange properties of an Book <\n1. Name\n2. Author\n3. Publisher\n4. Description");
                        option = notBlank();
                        if (option.charAt(0) == '1') {
                            String name = notBlank("Name: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            item.setName(name);
                            getFullInfo(item);
                        }
                        else if (option.charAt(0) == '2') {
                            String author = notBlank("Author: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            ((Book) item).setAuthor(author);
                            getFullInfo(item);
                        }
                        else if (option.charAt(0) == '3') {
                            String publisher = notBlank("Publisher: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            ((Book) item).setPublisher(publisher);
                            getFullInfo(item);
                        }
                        else if (option.charAt(0) == '4') {
                            String description = notBlank("Description: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            ((Book) item).setDescription(description);
                            getFullInfo(item);
                        }
                        else {
                            System.out.println("\nYou had chose option out of possible outcomes. Try again!\n");
                        }
                    }
                    else if (item instanceof Newspaper) {
                        System.out.println("\n\nChange properties of an Newspaper <\n1. Name\n2. Publisher\n3. Date of Release");
                        option = notBlank();
                        if (option.charAt(0) == '1') {
                            String name = notBlank("Name: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            item.setName(name);
                            getFullInfo(item);
                        }
                        else if (option.charAt(0) == '2') {
                            String publisher = notBlank("Publisher: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            ((Newspaper) item).setPublisher(publisher);
                            getFullInfo(item);
                        }
                        else if (option.charAt(0) == '3') {
                            LocalDate date = getValidDate();
                            scanner.nextLine();
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            ((Newspaper) item).setRelease(date);
                            getFullInfo(item);
                        }
                        else {
                            System.out.println("\nYou had chose option out of possible outcomes. Try again!\n");
                        }
                    }
                    else if (item instanceof Publication) {
                        System.out.println("\n\nChange properties of an Publication <\n1. Name\n2. Add an author\n3. Remove an author\n4. Topic");
                        option = notBlank();
                        if (option.charAt(0) == '1') {
                            String name = notBlank("Name: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            item.setName(name);
                            getFullInfo(item);
                        }
                        else if (option.charAt(0) == '2') {
                            String author = notBlank("Author: ");
                            if (((Publication) item).getAuthors().contains(author)) {
                                System.out.println("This publication already have " + author + " as one of it authors!");
                            }
                            else {
                                System.out.println("You have successfully change: ");
                                getFullInfo(item);
                                System.out.println("To: ");
                                ((Publication) item).getAuthors().add(author);
                                getFullInfo(item);
                            }
                        }
                        else if (option.charAt(0) == '3') {
                            String author = notBlank("Author: ");
                            if (((Publication) item).getAuthors().contains(author)) {
                                System.out.println("You have successfully change: ");
                                getFullInfo(item);
                                System.out.println("To: ");
                                ((Publication) item).getAuthors().remove(author);
                                getFullInfo(item);
                            }
                            else {
                                System.out.println("This publication don't have " + author + " as one of it authors!");
                            }
                        }
                        else if (option.charAt(0) == '4') {
                            String topic = notBlank("Topic: ");
                            System.out.println("You have successfully change: ");
                            getFullInfo(item);
                            System.out.println("To: ");
                            ((Publication) item).setTopic(topic);
                            getFullInfo(item);
                        }
                        else {
                            System.out.println("\nYou had chose option out of possible outcomes. Try again!\n");
                        }
                    }
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            ManageItems();
        }
        else if(option.charAt(0) == '4'){
            System.out.println("\n\n>  Remove an user <\nUser ID: ");
            String userID = scanner.nextLine();
            for(User user : User.getUserList()) {
                if(user.getUserID().equals(userID)) {
                    if(user.getItemsRented().size() == 0) {
                        System.out.println("Are you sure you want to remove " + user.getUserID() + ". " + user.getFullName() + "?\nY / N");
                        option = notBlank();
                        if(option.charAt(0) == 'Y' || option.charAt(0) == 'y') {
                            System.out.println("\nUser " + user.getUserID() + ". " + user.getFullName() + " has been successfully deleted!");
                            User.getUserList().remove(user); //Fixed ConcurrentModificationException by adding break, which also improves efficiency
                        }
                        else if(option.charAt(0) == 'N' || option.charAt(0) == 'n') {
                            System.out.println("\nYou declined deleting an user!");
                        }
                        else {
                            System.out.println("\nYou had chose option out of possible outcomes. Try again!\n");
                        }
                    }
                    else {
                        System.out.println("Can't delete an user! Items rented: ");
                        System.out.printf("%5s %-150s %15s %20s %10s %5s\n", "ID", "NAME", "DATE OF RENTING", "DATE OF RETURNING", "COST", "ID");
                        for(int j = 0; j < user.getItemsRented().size(); j++)
                            System.out.printf("%5s %-150s %15s %20s %10.2f %5s\n", user.getItemsRented().get(j).getId(), user.getItemsRented().get(j).getName(), user.getDateOfRenting().get(j), user.getDateOfReturning(j), user.getCost(j), user.getItemsRented().get(j).getId());
                    }
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            ManageItems();
        }
        else if(option.charAt(0) == '5'){
            System.out.println("\n\n> Change properties of an user <\nUser ID: ");
            String memberID = scanner.nextLine();
            for(User user : User.getUserList()) {
                if (user.getUserID().equals(memberID)) {
                    System.out.println("\n\n> Change properties of an user <\n1. Name\n2. Surname\n3. User ID");
                    option = notBlank();
                    if(option.charAt(0) == '1'){
                        String name = notBlank("Name: ");
                        System.out.println("You have successfully change: ");
                        System.out.println(user.getUserID() + ". " + user.getFullName() + ", phone number: " + user.getPhoneNumber());
                        System.out.println("To: ");
                        user.setName(name);
                        System.out.println(user.getUserID() + ". " + user.getFullName() + ", phone number: " + user.getPhoneNumber());
                    }
                    else if(option.charAt(0) == '2'){
                        String surname = notBlank("Surname: ");
                        System.out.println("You have successfully change: ");
                        System.out.println(user.getUserID() + ". " + user.getFullName() + ", phone number: " + user.getPhoneNumber());
                        System.out.println("To: ");
                        user.setSurname(surname);
                        System.out.println(user.getUserID() + ". " + user.getFullName() + ", phone number: " + user.getPhoneNumber());
                    }
                    else if(option.charAt(0) == '3'){
                        long phoneNumber;
                        do {
                            System.out.println("Phone number: ");
                            phoneNumber = scanner.nextLong();
                            System.out.println(Long.toString(phoneNumber).length());
                        } while(Long.toString(phoneNumber).length()!=9);
                        scanner.nextLine();
                        boolean check = true;
                        for(User phoneCheck : User.getUserList()){ //This weird loop is necessary to check if phone number won't duplicate in database.
                            if (phoneCheck.getPhoneNumber().equals((int) phoneNumber)) {
                                check = false;
                                break;
                            }
                        }
                        if(check) {
                            System.out.println("You have successfully change: ");
                            System.out.println(user.getUserID() + ". " + user.getFullName() + ", phone number: " + user.getPhoneNumber());
                            System.out.println("To: ");
                            user.setPhoneNumber((int) phoneNumber);
                            System.out.println(user.getUserID() + ". " + user.getFullName() + ", phone number: " + user.getPhoneNumber());
                        }
                        else {
                            System.out.println("You can't set phone number to " + phoneNumber + ", because it's already used!");
                        }
                    }
                    else {
                        System.out.println("\nYou had chose option out of possible outcomes. Try again!\n");
                    }
                    break;
                }
            }
            System.out.println("\n\nClick anything to return...");
            scanner.nextLine();
            ManageItems();
        }
        else if(option.charAt(0) == '6'){
            System.out.println("\n\n> Change general settings <\n1. How many months are free while renting (now " + User.getMonthsForFree() + ")\n2. Cost per day of delay (now " + User.getCostPerDayOfDelay() + ")\n\n0. Back");
            option = notBlank();
            if(option.charAt(0)=='1'){
                System.out.println("\n\nHow many months are free while renting?");
                int months;
                do{
                    System.out.println("Months: ");
                    months = scanner.nextInt();
                } while(months<0);
                scanner.nextLine();
                System.out.println("Changed amount of months free from charging after renting from: ");
                System.out.println(User.getMonthsForFree());
                System.out.println("To: ");
                User.setMonthsForFree(months);
                System.out.println(User.getMonthsForFree());
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                ManageItems();
            }
            else if(option.charAt(0)=='2'){
                System.out.println("\n\nCost per day of delay");
                double cost;
                do {
                    System.out.println("Cost: ");
                    cost = scanner.nextDouble();
                } while(cost<0);
                scanner.nextLine();
                System.out.println("Changed cost per every day of delay from: ");
                System.out.println(User.getCostPerDayOfDelay());
                System.out.println("To: ");
                User.setCostPerDayOfDelay(cost);
                System.out.println(User.getCostPerDayOfDelay());
                System.out.println("\n\nClick anything to return...");
                scanner.nextLine();
                ManageItems();
            }
            else if(option.charAt(0)=='0'){
                System.out.println("\n\n");
                ManageItems();
            }
            else {
                System.out.println("\nYou had chose option out of possible outcomes. Try again!\n");
            }
        }
        else if(option.charAt(0) == '0'){
            Database();
        }
        else {
            System.out.println("You had chose option out of possible outcomes. Try again!\n");
            ManageItems();
        }
    }

    //Private methods only to shorten the code
    private static void printItemsRented(User user){
        if(user.getItemsRented().size()>0) {
            System.out.println("Items rented:");
            System.out.printf("%5s %-150s %15s %20s %10s %5s\n", "ID", "NAME", "DATE OF RENTING", "DATE OF RETURNING", "COST", "ID");
            for(int i = 0; i < user.getItemsRented().size(); i++) {
                System.out.printf("%5s %-150s %15s %20s %10.2f %5s\n", user.getItemsRented().get(i).getId(), user.getItemsRented().get(i).getName(), user.getDateOfRenting().get(i), user.getDateOfReturning(i), user.getCost(i), user.getItemsRented().get(i).getId());
            }
            System.out.printf("\n%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
        }
    }

    private static void getFullInfo(Item item){
        System.out.printf("%5s %-150s %10s %5s %5s\n", "ID", "NAME", "AVAILABLE", "RENTED", "ID");
        System.out.printf("%5d %-150s %10d %6d %5d\n", item.getId(), item.getName(), item.getAmountAvailable(), item.getAmountRented(), item.getId());
        item.getInfo();
    }

    //Those methods are used to prevent error occurring due to no data input while pressing the enter key
    private static String notBlank(){
        String string;
        do{
            string = scanner.nextLine();
        }while(string.isBlank());
        return string;
    }

    private static String notBlank(String message){
        String string;
        do{
            System.out.println(message);
            string = scanner.nextLine();
        }while(string.isBlank());
        return string;
    }

    //Method to get correct format of dates
    private static LocalDate getValidDate(){
        System.out.println("\n\nAll value of date need to be as integer.");
        int year, month, day;
        do{
            System.out.println("Year: ");
            year = scanner.nextInt();
        } while(year<1);
        scanner.nextLine();
        do{
            System.out.println("Month: ");
            month = scanner.nextInt();
        } while(month<1 || month>12);
        scanner.nextLine();
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
            do{
                System.out.println("Day: ");
                day = scanner.nextInt();
            } while(day<1 || day>31);
        } else if (month==4 || month==6 || month==9 || month==11){
            do{
                System.out.println("Day: ");
                day = scanner.nextInt();
            } while(day<1 || day>30);
        } else {
            if(year%4==0){
                do{
                    System.out.println("Day: ");
                    day = scanner.nextInt();
                } while(day<1 || day>29);
            } else {
                do{
                    System.out.println("Day: ");
                    day = scanner.nextInt();
                } while(day<1 || day>28);
            }
        }
        scanner.nextLine();
        return LocalDate.of(year, month, day);
    }
}

