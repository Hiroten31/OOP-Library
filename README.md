# Objected Oriented Programming - Library
Imagine you are an employee in a library. And you have a screen and a customer in front of you.
<img src="https://user-images.githubusercontent.com/97809912/224180115-117410ed-49f4-4ccd-9cb8-cd3c05fccc3f.jpg" width="750">

## How to install?
Just import it to your IDE and run the Main file!  
## What does it do?  
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
The item need to be fully return to being removed from database.  
- **You won't be able to create a Member with the same phone number.**  
[Try to register member with 123456789 phone number]  
Items are rented by phone number, because who doesn't have their OWN phone number nowadays?  
- **You won't crash the program by entering wrong values!**  
[Try to enter character instead of integer when asked]  
By using try...catch and do...while program will forgive you all mistakes! *I hope...*  
- **You can safely manage items as much as you can**
[Try to remove or add as many items as you want]
System will automatically distribute IDs in a way they won't duplicate ever!
- **Also it's relatively efficent**
[Here a little bit of code with for loop]
Unfortunately there are for loops in for loops, but they are breaked as soon as possible!

## How does it work?
Let's start with a files.
### package: classes
- file: Item.java
- file: Book.java
- file: Newspaper.java
- file: Publication.java
### package: data
- file: Items.ser, Members.ser
- file: Settings.txt
### package: main
- file: Main.java
- file: Menu.java  
the biggest boi  
  
Logic behind it.  

## What I've learned from it?
A LOT.
