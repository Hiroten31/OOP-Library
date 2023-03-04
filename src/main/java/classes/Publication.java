package classes;

import java.util.ArrayList;
import java.util.List;

public class Publication extends Item {

    private final List<String> authors = new ArrayList<>();
    private String topic;

    //Basic method to create an object
    public Publication(String name, String topic, int amountAvailable, int amountRented) {
        this.name = name;
        this.topic = topic;
        this.amountAvailable = amountAvailable;
        this.amountRented = amountRented;
    }

    //Getters and Setters
    public List<String> getAuthors() {
        return authors;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    //Implementation of the method from Item.class
    @Override
    public void getInfo(){
        System.out.println("Publication: " + getName());
        System.out.println("\tAuthors: " + authors.toString());
        System.out.println("\tTopic: " + topic);
        System.out.println();
    }
}
