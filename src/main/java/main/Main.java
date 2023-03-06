package main;

import classes.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Directory of files storing Items and Members data.
        File ItemsFile = new File("src/main/java/data/Items.ser");
        File MembersFile = new File("src/main/java/data/Members.ser");
        File SettingsFile = new File("src/main/java/data/Settings.txt");

        ////Loading
        //Items
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
        //Members
        if(MembersFile.exists()){
            try {
                FileInputStream readData = new FileInputStream(MembersFile);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                Member.setMembers((ArrayList<Member>) readStream.readObject());
                readStream.close();
                System.out.println("Members loaded.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no file to load Members data from.\nCheck if had you provide correct direction.\nIgnore if it is the first time running the program!");
        }
        //Settings
        if(SettingsFile.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(SettingsFile));
                Member.setMonthsForFree(Integer.parseInt(br.readLine()));
                Member.setCostPerDayOfDelay(Double.parseDouble(br.readLine()));
                System.out.println("Settings loaded.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no file to load Settings from.\nCheck if had you provide correct direction.\nIgnore if it is the first time running the program!");
        }


        Menu.Start();


        ////Saving
        //Items
        System.out.println("\n\n");
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
        //Members
        try {
            FileOutputStream writeData = new FileOutputStream(MembersFile);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(Member.getMemberList());
            writeStream.flush();
            writeStream.close();
            System.out.println("Members saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Settings
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(SettingsFile));
            bw.write(Member.getMonthsForFree() + "\n");
            bw.write(Member.getCostPerDayOfDelay() + "\n");
            bw.flush();
            bw.close();
            System.out.println("Settings saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
        //TODO: fix dates of renting and returning, make reasonable items and members for testing, fix error after entering wrong input in nextInt() and nextDouble();
    }
}