/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserInterface_jButton9_actionAdapter
implements ActionListener {
    UserInterface adaptee;

    UserInterface_jButton9_actionAdapter(UserInterface adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        this.adaptee.jButton9_actionPerformed(e);
    }
}
