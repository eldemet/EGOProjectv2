/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.Item;
import egoproject.People;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Room {
    private String description;
    private HashMap exits;
    private String imagePath;
    private ArrayList items;
    private People person;
    private String roomId;

    public Room(String description, String imagePath) {
        this(resolveRoomId(imagePath), description, imagePath);
    }

    public Room(String roomId, String description, String imagePath) {
        this.roomId = roomId;
        this.description = description;
        this.imagePath = imagePath;
        this.exits = new HashMap();
        this.items = new ArrayList();
    }

    public void changeImagePath(String newPath) {
        this.imagePath = newPath;
    }

    public Room getExit(String direction) {
        return (Room)this.exits.get(direction);
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set keys = this.exits.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            returnString = returnString + " " + iter.next();
        }
        return returnString;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public ArrayList getItems() {
        return this.items;
    }

    public String getLongDescription() {
        return this.description + "\n" + this.getExitString();
    }

    public String getPersonIconPath() {
        return this.person.getIconPath();
    }

    public String getPersonTalk() {
        return this.person.getPeopleWords();
    }

    public String getRoomItems() {
        String returnString = "";
        int i = 0;
        while (i < this.items.size()) {
            returnString = returnString + this.items.get(i) + " ";
            ++i;
        }
        return returnString;
    }

    public String getShortDescription() {
        return this.description;
    }

    public boolean hasItem(String s) {
        int i = 0;
        while (i < this.items.size()) {
            if (this.items.get(i).equals(s)) {
                return true;
            }
            ++i;
        }
        return false;
    }

    public boolean hasPerson() {
        return this.person != null;
    }

    public boolean is(String string) {
        return this.roomId.startsWith(string);
    }

    public void removeItem(String itemName) {
        String itemNames = "";
        int i = 0;
        while (i < this.items.size()) {
            if (this.items.get(i).equals(itemName)) {
                this.items.remove(i);
                break;
            }
            ++i;
        }
    }

    public void removePerson() {
        this.person = null;
    }

    public void setExit(String direction, Room neighbor) {
        this.exits.put(direction, neighbor);
    }

    public void setItem(String string) {
        this.items.add(string);
    }

    public void setItem(Item item) {
        this.items.add(item);
    }

    public void setPerson(People mother) {
        this.person = mother;
    }

    public void setPersonIconPath(String s) {
        this.person.setIconPath(s);
    }

    public void setPersonTalk(String s) {
        this.person.setPeopleWords(s);
    }

    private static String resolveRoomId(String imagePath) {
        int lastSlash = Math.max(imagePath.lastIndexOf('/'), imagePath.lastIndexOf('\\'));
        String fileName = lastSlash >= 0 ? imagePath.substring(lastSlash + 1) : imagePath;
        int dotIndex = fileName.lastIndexOf('.');
        return dotIndex >= 0 ? fileName.substring(0, dotIndex) : fileName;
    }
}
