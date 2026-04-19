/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.UserInterface;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class UserInterface_this_windowAdapter
extends WindowAdapter {
    UserInterface adaptee;

    UserInterface_this_windowAdapter(UserInterface adaptee) {
        this.adaptee = adaptee;
    }

    public void windowClosing(WindowEvent e) {
        this.adaptee.this_windowClosing(e);
    }
}
