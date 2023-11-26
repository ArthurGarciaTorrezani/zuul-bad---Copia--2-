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

    /**
     * @return The description of the room.
     */
    public Room getExit(String direction) {
        return exits.get(direction) != null ? exits.get(direction) : null;

    }

    public String getLongDescription(){
        String information = "";

        Set<String> keys = exits.keySet();
        for (String direction : keys) {
            information += " " + direction;
        }

        return "\n"+"You are "+ description + "\n" + "Exits: "+information;
    }

    
}
