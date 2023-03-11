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
- **You won't be able to remove an user who has rented books.**  
[Try to remove Dwight - 311141027]  
The member need to return all of it items to being able to be removed.  

- **You won't be able to remove an item which is still rented.**  
[Try to remove Part bosses' - 5]  
The item need to be fully returned to being removed from database.  

- **You won't be able to create a Member with the same phone number.**  
[Try to register member with 123456789 phone number]  
Items are rented by phone number, because who doesn't have their OWN phone number nowadays?  
<sub>which also take responsibility for unique members ID from me to mobile network companies🤐</sub>

- **You won't crash the program by entering wrong values!**  
[Try to enter character instead of integer when asked or option out of possible outcomes]  
By using try...catch and do...while program will forgive you all mistakes! *I hope...*  

- **You can safely manage items as much as you can**  
[Try to remove or add as many items as you want]  
System will automatically distribute IDs in a way they won't duplicate ever!  

- **Also it's relatively efficent**  
[Here a little bit of code with for loop]  
Unfortunately there are for loops in for loops, but they are breaked as soon as possible!  


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

The static list named Items is used to easily save and work on items within one collections.  

This class have one very important method:
```java
Item() {
  ++count;
  this.id = count;
  Items.add(this);
}
```
Which is called every time an object (that implements Item class) is created. It is keeping track of ID distribution in database.  
  
To being able to rent and return item we use those two methods:
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

The last method
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
    <td>author, publisher, description</td>
    <td>publisher, release</td>
    <td>authors, topic</td>
  </tr>
</table>
Of course each of them have their own getters and setters methods needed for correct program standars as *Clean Code*.  
  
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
    <td>List of items rented by member. Methods <i>rentsItem(Item item)</i> and <i>returnsItem(Item item)</i> are controlling the content of the list.</td>
  </tr>
  <tr>
    <td><b>dateOfRenting</b></td>
    <td>Store dates in the same order as items in ItemsRented.</td>
  </tr>
  <tr>
    <td><b>members</b></td>
    <td>List of all members, <i>static</i> because it is the same for everyone.</td>
  </tr>
</table>
Today I would just use a HashMap to fuse the first two lists, because it would for sure be more clear, easier to control and safer :brain:  
<br/><br/><br/>
  There are also the other two static variables which are:  
<table>
  <tr>
    <td><b>monthsForFree</b></td>
    <td>how many months are supposed to be cost-free.</td>
  </tr>
  <tr>
    <td><b>costPerDayOfDelay</b></td>
    <td>how much system is charging for every single day of being late with returning an item.</td>
  </tr>
</table>
Those two static variables are in member, because of the dateOfRenting list which is necessary to count the cost. I think it would be pointless to declare them anywhere else.  
<br/><br/>
Also you could ask: <br/>
<blockquote> Why there is a String <i>memberID</i> AND an Integer <i>phoneNumber</i> if there have the same value as said before? </blockquote>

WELL, I thought about setting memberID for people without phone number as: first letter of name + first letter of surname + date of registering.  
<br/> BUT, then I would be need to add some ifs to check if they are not duplicated and came to conclusion that everybody has their own number today, so this is just leftovers, which I didn't get rid of because maybe one day I'll build it further, who knows?
  
<hr>  
  
### package: data  
- file: Items.ser, Members.ser
- file: Settings.txt

### package: main  
- file: Main.java
- file: Menu.java  
the biggest boi  
  
Logic behind it.  

## ✍️ What I've learned from it?
A LOT.
