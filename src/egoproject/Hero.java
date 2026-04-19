/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import java.util.ArrayList;

public class Hero {
    boolean bag = false;
    boolean buscoin = false;
    boolean classout = false;
    boolean findtrap = false;
    boolean guardaway = false;
    boolean guardclear = false;
    int guardtalk = 0;
    boolean headmasterout = false;
    int headmastertalk = 0;
    ArrayList inventory = new ArrayList();
    boolean kitchensafe = false;
    boolean locked = true;
    boolean madchipon = false;
    boolean madeyesshut = false;
    boolean madout = false;
    int madtalk1 = 0;
    boolean paperrequest;
    boolean shoes = false;
    boolean theend = false;
    boolean tiedup = true;
    boolean unplugged = false;

    public void addItem(String s) {
        this.inventory.add(s);
    }

    public boolean hasItem(String s) {
        int i = 0;
        while (i < this.inventory.size()) {
            if (this.inventory.get(i).equals(s)) {
                return true;
            }
            ++i;
        }
        return false;
    }

    public void removeItem(String s) {
        int i = 0;
        while (i < this.inventory.size()) {
            if (s.equals(this.inventory.get(i))) {
                this.inventory.remove(i);
                break;
            }
            ++i;
        }
    }
}
