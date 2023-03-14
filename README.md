# 📚 Objected Oriented Programming - Library 
<p align="center">
Imagine you are an employee in a library. You have a screen and a customer in front of you.
<img src="https://user-images.githubusercontent.com/97809912/224438357-047fbe21-40d5-4df8-bfa1-025b50566857.jpg" width="750">
<br/>The system that is showing up on the screen is the project that you have found here 😁
</p>


## ⚙️ How to install it?
Just import it to your IDE and run the Main file!  
## 🤸 What does it do?
It's a fully working system to manage typical items in typical library. It has ability to:
- register new member
- rent and return items by member
- search through database
- serialize data
- add and remove items, as well as members  
  
The system is fully secure! :lock:  
- **You won't be able to remove an user who still have rented books.**  
[Try to remove Dwight - ID: `311141027`]  
The member need to return all of his rented items to being able to be removed.  

- **You won't be able to remove an item which is still rented.**  
[Try to remove Part bosses' - ID: `5`]  
The item need to be fully returned to be removed from database.  

- **You won't be able to create a Member with the same phone number.**  
[Try to register member with `123456789` phone number]  
Items are rented by phone number, because who doesn't have their OWN phone number nowadays?  
<sub>which also take responsibility for unique members ID from me to mobile network companies🤐</sub>

- **You won't crash the program by entering wrong values!**  
[Try to enter character instead of integer when asked or enter an option out of possible outcomes]  
By using try...catch and do...while program will forgive all of yours mistakes! *I hope...*  

- **You can safely manage items as much as you can**  
[Try to remove or add as many items as you want]  
System will automatically distribute IDs in a way they won't duplicate ever!  

## 🤔 How does it work?
Let's start with the files.  
| package | files | 
| --- | --- |
| [`classes`](#package-classes) | Item.java<br/>Book.java<br/>Newspaper.java<br/>Publication.java |
| [`data`](#package-data) | Items.ser<br/>Members.ser<br/>Settings.txt |
| [`main`](#package-main) | Main.java<br/>Menu.java |  
### package: classes
- file: Item.java  

An abstract class that declare **ID**, **name**, as well as **amount available** and **amount rented** for every single item. Also it has a list of *Members* named **rentedByMembersID**, because every item will have to store by which member it has been rented.  

The static list named **Items** is used to easily save and work on items within one collections.  

This class have one very important method:
```java
Item() {
  ++count;
  this.id = count;
  Items.add(this);
}
```
Which is called every time an object (that extends Item class) is created. It is keeping track of ID distribution in database.  
  
To being able to rent and return an item we use those two methods:
```java
public void rentItem(Member member){
  amountAvailable--;
  amountRented++;
  rentedByMembersID.add(member);
  member.rentsItem(this);
}

public void returnItem(Member member){
  amountAvailable++;
  amountRented--;
  rentedByMembersID.remove(member);
  member.returnsItem(this);
}
```
Of course it is in the abstract class to being inherit by every type of item we have to not duplicate the same methods.

The last method:
```java
public abstract void getInfo();
```
is just for training the usage of interface methods.  
  
<hr>  

- file: Book.java, Newspaper.java, Publication.java  

Those are classes that implements Item class. Every of them have unique parameters typical for each type.
<table>
  <tr>
    <td>Book</td>
    <td>Newspaper</td>
    <td>Publication</td>
  </tr>
  <tr>
    <td>author<br/>publisher<br/>description</td>
    <td>publisher<br/>release</td>
    <td>authors<br/>topic</td>
  </tr>
</table>
Of course each of them have their own getters and setters methods needed for correct programming standards of *Clean Code*.  
  
<sub>(I forgot THE name of this practice)</sub>  
   
   
   
The method getInfo() in every class is a simple printer of their unique parameters (example of Book class):
```java
@Override
public void getInfo(){
  System.out.println("Book: " + getName());
  System.out.println("\tAuthor: " + author);
  System.out.println("\tPublisher: " + publisher);
  System.out.println("\tDescription: " + description);
  System.out.println();
}
```
<hr>  
  
- file: Member.java  

It is a class that contain all parameters of a member. It has 3 array lists:  
<table>
  <tr>
    <td><b>ItemsRented</b></td>
    <td>List of items rented by a member. Methods <i>rentsItem(Item item)</i> and <i>returnsItem(Item item)</i> are controlling the content of the list.</td>
  </tr>
  <tr>
    <td><b>dateOfRenting</b></td>
    <td>Store dates in the same order as items in ItemsRented.</td>
  </tr>
  <tr>
    <td><b>members</b></td>
    <td>Genaral list of all members, <i>static</i> because it is the same for everyone.</td>
  </tr>
</table>
Today I would just use a HashMap to fuse together the first two lists, because it would for sure be more clear, easier to control and safer :brain:  
<br/><br/><br/>
  There are also the other two static variables which are:  
<table>
  <tr>
    <td><b>monthsForFree</b></td>
    <td>how many months are supposed to be cost-free.</td>
  </tr>
  <tr>
    <td><b>costPerDayOfDelay</b></td>
    <td>how much the system is charging for every single day beyong the free months.</td>
  </tr>
</table>
Those two static variables are in member, because of the dateOfRenting list which is using it to count the costs. I think it would be pointless to declare them anywhere else.  
<br/><br/>
Also you could ask: <br/>
<blockquote> Why there is a String <i>memberID</i> AND an Integer <i>phoneNumber</i> if there have the same value as said before? </blockquote>

WELL, I thought about setting memberID for people without phone number as: first letter of name + first letter of surname + date of registering.  
<br/> BUT, then I would be need to add some ifs to check if they are not duplicated, more option to click to set it correctly and came to conclusion that everybody has their own number today, so this is just leftovers, which I didn't get rid of because maybe one day I'll build it further, who knows?
  
<hr>  
  
### package: data  
- file: Items.ser, Members.ser  

Those are files that are coded by compiler and usage of `Serializable` interface in those classes. They are holding all vulnerable data (especially in case of Members.ser). They are loaded and saved in Main.java. You can also easily change the path of where to save those files in Main.java as the path is saved as variable. 
```java
File ItemsFile = new File("src/main/java/data/Items.ser");
File MembersFile = new File("src/main/java/data/Members.ser");
File SettingsFile = new File("src/main/java/data/Settings.txt");
```
- file: Settings.txt  

A text file with just two values, first of free months, second of cost per day of delay. It is saved as .txt file as those aren't any personal data and there is no need to crypt it. It is required to be as those two values are static variables, so they cannnot be serialized like before.

### package: main  
- file: Main.java  

Main file with `main()` function to start the program. Additionally it contains a loading and saving system as those are basic functions that need to be run before everything else. Example of Items.ser file loading:
```java
if(ItemsFile.exists()){
  try {
    FileInputStream readData = new FileInputStream(ItemsFile);
    ObjectInputStream readStream = new ObjectInputStream(readData);
    Item.setItems((ArrayList<Item>) readStream.readObject());
    readStream.close();
    System.out.println("Items loaded.");
  } catch (Exception e) {
    e.printStackTrace();
  }
} else {
  System.out.println("There is no file to load Items data from.\nCheck if had you provide correct direction.\nIgnore if it is the first time running the program!\n\n");
}
```  
And example of the same file saving:
```java
try {
  FileOutputStream writeData = new FileOutputStream(ItemsFile);
  ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
  writeStream.writeObject(Item.getItemList());
  writeStream.flush();
  writeStream.close();
  System.out.println("Items saved.");
} catch (IOException e) {
  e.printStackTrace();
}
```  
Between them is run one function, `Menu.Start()` that smoothly lead us to the biggest code file in this project.
<hr>  

- file: Menu.java  

File that mostly works with loops, printing messages and if statements.  
Methods are orginazed in the levels of how deep into those methods we are going. 
<details>
  <summary><b>Whole structure of the closed methods looks like this:</b></summary>
  
```java
//Method accessed from main() - 1 level
static void Start(){...}

//Methods accessed from Start() - 2 level
static void Database(){...}
static void Renting(){...}
static void Returning(){...}
static void Register(){...}

//Methods accessed from Database() - 3 level.
static void SearchForItem(){...}
static void BrowseThroughItems(){...}
static void SearchForMember(){...}
static void GetInfo(){...}
static void ManageItems(){...}
```
</details>  
  
So we begin with method `Start()` which is the first level called from `main()` method.
```java
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
  else if(option.charAt(0) == '0'){}
  else {
    System.out.println("You had chose option out of possible outcomes. Try again!\n\n");
    Start();
  }
}
```
Usually every method is build like this:
1. Message informing of what options you have
2. Scanner to get user's input
3. ifs to check the input
4. Closing methods and messages like "Click anything to return..."

From `Start()` we can go to `Database()` which has very similar build to the first method. All of their options are just to move one level deeper.
The whole file is pretty much all over and over the same stuff and searching through earlier created lists of objects. Example of searching for member by full name (*line 319 in Menu.java*):
```java
System.out.println("\n\n> Search for member by full name <\nFull name: ");
String fullName = notBlank();
System.out.printf("%10s %-35s %25s %10s\n", "ID", "FULL NAME", "DATE OF JOINING", "PHONE NUMBER");
for(Member member : Member.getMemberList()) {
  if(member.getFullName().equals(fullName)) {
    System.out.printf("%10s %-35s %25s %10d\n", member.getMemberID(), member.getFullName(), member.getJoinDate(), member.getPhoneNumber());
    printItemsRented(member);
  }
}
```
As you can see we are searching through list of members.  
<details>
<summary><b>We get our input by method called 'notBlank()' used to secure entering empty String:</b></summary>

```java
private static String notBlank(){
  String string;
  do {
    string = scanner.nextLine();
  } while(string.isBlank());
  return string;
}
```
</details>  
Next we are printing a nice table of all the information about members who have `fullName` matching.
<img src="https://user-images.githubusercontent.com/97809912/224850140-d88ef46f-937f-4abc-9e8a-3fcc5fda67ed.png" width="100%">
In this case we can't use `break` for better efficency of the loop as there can be more than one member having the same full name as the other. I used `break` only in loops which are searching for unique values as IDs or phone numbers.
<br/><br/>
<details>
<summary><b>There is also a second method that secures a valid date format input</b></summary>

```java
private static LocalDate getValidDate(){
  System.out.println("\n\nAll value of date need to be as integer.");
  int year, month, day;
  do {
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
    do {
      System.out.println("Day: ");
      day = scanner.nextInt();
    } while(day<1 || day>31);
  } else if (month==4 || month==6 || month==9 || month==11) {
    do {
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
      do {
        System.out.println("Day: ");
        day = scanner.nextInt();
      } while(day<1 || day>28);
    }
  }
  scanner.nextLine();
  return LocalDate.of(year, month, day);
  }
}
```
</details>  
  
And this is pretty much all that is occuring in this file.  
Of course I could split it into few files in separated package, but not only it would take me a while to do it, files would have a lot of imports and could result in worse clarity overall.
  
## ✍️ What I've learned from it?
I have for sure trained objected oriented programming. I almost used every aspect that I have learned before like:
  - abstract classes and interfaces
  - polymorphism
  - overloading methods
  - try{...}catch 
  - array lists
  - creating new instances of class
  - working with objects
  - foreach loop
  - serialization of data
  - using static and final keywords.  
  
It is **completely original**, I haven't followed any tutorial, so overall I can say it turned out pretty well.  
It WORKS which is most important, it is somewhat clear and I have used stuff that I wanted to use.   
