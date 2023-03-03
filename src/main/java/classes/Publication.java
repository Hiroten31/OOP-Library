package classes;

import java.util.ArrayList;
import java.util.List;

public class Publication extends Item {
    private List<String> authors = new ArrayList<>();
    private String topic;
    public List<String> getAuthors() {
        return authors;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public Publication(String name, String topic, int amountAvailable, int amountRented) {
        this.name = name;
        this.topic = topic;
        if(amountAvailable>=0) {
            this.amountAvailable = amountAvailable;
        } else {
            System.out.println("You gave an incorrect number! Amount available will be set to 0.");
            this.amountAvailable = 0;
        }
        if(amountRented>=0){
            this.amountRented = amountRented;
        } else {
            System.out.println("You gave an incorrect number! Amount rented will be set to 0.");
            this.amountRented = 0;
        }
    }
    public void addAuthor(String author){
        authors.add(author);
    }
    @Override
    public void getInfo(){
        System.out.println("Publication: " + getName());
        System.out.println("\tAuthors: " + authors.toString());
        System.out.println("\tTopic: " + topic);
        System.out.println();
    }
}
