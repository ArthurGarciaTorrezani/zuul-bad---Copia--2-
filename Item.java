import java.util.Optional;
public class Item {
    private String description;
    private int weight; // peso
    private String name;
    private int amount;

    public Item(String description, int weight, String name, int amount){
        this.description = description;
        this.weight = weight;
        this.name = name.toLowerCase();
        this.amount = amount;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }
}
