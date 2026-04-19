/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.UserInterface;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class UserInterface_jTextField2_mouseAdapter
extends MouseAdapter {
    UserInterface adaptee;

    UserInterface_jTextField2_mouseAdapter(UserInterface adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        this.adaptee.jTextField2_mouseClicked(e);
    }
}
