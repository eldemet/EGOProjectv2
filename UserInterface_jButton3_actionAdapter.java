/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserInterface_jButton3_actionAdapter
implements ActionListener {
    UserInterface adaptee;

    UserInterface_jButton3_actionAdapter(UserInterface adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        this.adaptee.jButton3_actionPerformed(e);
    }
}
