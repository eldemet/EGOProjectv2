/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserInterface_jTextField2_actionAdapter
implements ActionListener {
    UserInterface adaptee;

    UserInterface_jTextField2_actionAdapter(UserInterface adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        this.adaptee.jTextField2_actionPerformed(e);
    }
}
