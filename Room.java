import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game. It is
 * connected to other rooms via exits. The exits are labelled north,
 * east, south, west. For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits = new HashMap<String, Room>();
    private ArrayList<Item> itemsOnRoom = new ArrayList<Item>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * Define the exits of this room. Every direction either leads
     * to another room or is null (no exit there).
     * 
     * @param north The north exit.
     * @param east  The east east.
     * @param south The south exit.
     * @param west  The west exit.
     */

    public void setExit(String direction, Room neightbor) {
        exits.put(direction, neightbor);
    }

    private void setItem(Item item) {
        itemsOnRoom.add(item);
    }

    public void createItem(String description, int weight, String name, int amount) {
        Item item = new Item(description, weight, name, amount);
        setItem(item);
    }

    /**
     * @return The description of the room.
     */
    public Room getExit(String direction) {
        return exits.get(direction) != null ? exits.get(direction) : null;
    }

    private String getExitString() {
        String information = "";

        Set<String> keys = exits.keySet();
        for (String direction : keys) {
            information += " " + direction;
        }
        return information;
    }

    private String getItems() {
        String information = "";

        for (Item item : itemsOnRoom) {
            information += " " + item.getName();
        }
        return information;
    }

    public void getLongDescription() {
        System.out.println(
                "\n" + "You are " + description + "\n" + "Exits: " + getExitString() + "\n" + " Items " + getItems());
    }

}
