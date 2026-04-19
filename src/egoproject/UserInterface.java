/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.GameEngine;
import egoproject.UserInterface_jButton1_actionAdapter;
import egoproject.UserInterface_jButton2_actionAdapter;
import egoproject.UserInterface_jButton3_actionAdapter;
import egoproject.UserInterface_jButton4_actionAdapter;
import egoproject.UserInterface_jButton5_actionAdapter;
import egoproject.UserInterface_jButton6_actionAdapter;
import egoproject.UserInterface_jButton7_actionAdapter;
import egoproject.UserInterface_jButton8_actionAdapter;
import egoproject.UserInterface_jButton9_actionAdapter;
import egoproject.UserInterface_jTextField2_actionAdapter;
import egoproject.UserInterface_jTextField2_mouseAdapter;
import egoproject.UserInterface_this_windowAdapter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UserInterface
        extends JFrame {
    static /* synthetic */ Class class$egoproject$UserInterface;
    ImageIcon downtIcon;
    private GameEngine engine;
    ImageIcon helpIcon;
    Vector inventoryItems;
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JButton jButton6;
    JButton jButton7;
    JButton jButton8;
    JButton jButton9;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JList jList1;
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextArea jTextArea1 = new JTextArea();
    JTextField jTextField1;
    JTextField jTextField2;
    ImageIcon leftIcon;
    ImageIcon lookIcon;
    ImageIcon rightIcon;
    ImageIcon takeIcon;
    ImageIcon talkIcon;
    TitledBorder titledBorder1;
    TitledBorder titledBorder2;
    TitledBorder titledBorder3;
    ImageIcon upIcon;
    ImageIcon useIcon;

    public UserInterface(GameEngine gameEngine) {
        super("The EGO Project (2004)");
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.jTextField1 = new JTextField();
        this.jTextField2 = new JTextField();
        this.jButton5 = new JButton();
        this.jButton6 = new JButton();
        this.jButton7 = new JButton();
        this.jLabel2 = new JLabel();
        this.upIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/arrowup.png"));
        this.rightIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/arrowright.png"));
        this.leftIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/arrowleft.png"));
        this.downtIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/arrowdown.png"));
        this.lookIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/look.png"));
        this.takeIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/take.png"));
        this.useIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/use.png"));
        this.talkIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/talk.png"));
        this.helpIcon = new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource("img/help.png"));
        this.jButton8 = new JButton();
        this.jButton9 = new JButton();
        this.jLabel3 = new JLabel();
        this.inventoryItems = new Vector();
        this.jList1 = new JList(this.inventoryItems);
        this.jLabel4 = new JLabel();
        this.engine = gameEngine;
        try {
            this.jbInit();
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }

    public void addListItem(String s) {
        this.inventoryItems.addElement(s);
        this.jList1.setListData(this.inventoryItems);
        this.jList1.repaint();
    }

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }

    void jButton1_actionPerformed(ActionEvent e) {
        this.engine.interpretCommand("go back");
    }

    void jButton2_actionPerformed(ActionEvent e) {
        this.engine.interpretCommand("go forward");
    }

    void jButton3_actionPerformed(ActionEvent e) {
        this.engine.interpretCommand("go right");
    }

    void jButton4_actionPerformed(ActionEvent e) {
        this.engine.interpretCommand("go left");
    }

    void jButton5_actionPerformed(ActionEvent e) {
        this.engine.interpretCommand("look");
    }

    void jButton6_actionPerformed(ActionEvent e) {
        this.jTextField2.setText("take ");
    }

    void jButton7_actionPerformed(ActionEvent e) {
        if (this.jList1.getSelectedIndex() != -1) {
            int[] a = this.jList1.getSelectedIndices();
            if (a.length > 2) {
                return;
            }
            if (a.length == 1) {
                this.engine.interpretCommand("use " + this.jList1.getSelectedValue());
            } else {
                int[] b = this.jList1.getSelectedIndices();
                this.engine
                        .interpretCommand("use " + this.inventoryItems.get(b[0]) + " " + this.inventoryItems.get(b[1]));
            }
        } else {
            this.engine.interpretCommand("use");
        }
        this.jList1.clearSelection();
    }

    void jButton8_actionPerformed(ActionEvent e) {
        this.engine.interpretCommand("talk");
    }

    void jButton9_actionPerformed(ActionEvent e) {
        this.engine.interpretCommand("help");
    }

    void jTextField2_actionPerformed(ActionEvent e) {
        String str = this.jTextField2.getText();
        this.jTextField2.setText("");
        if (!str.equals("write commands here") && !str.equals("")) {
            this.engine.interpretCommand(str);
        }
    }

    void jTextField2_mouseClicked(MouseEvent e) {
        if (!this.jTextField2.getText().equals("take ")) {
            this.jTextField2.setText("");
        }
    }

    private void jbInit() {
        this.titledBorder1 = new TitledBorder("");
        this.titledBorder2 = new TitledBorder("");
        this.titledBorder3 = new TitledBorder("");
        this.jLabel1.setBackground(Color.black);
        this.jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jLabel1.setText("pictures");
        this.jLabel1.setBounds(new Rectangle(141, 10, 550, 400));
        this.getContentPane().setBackground(Color.black);
        this.setForeground(Color.lightGray);
        this.setResizable(false);
        this.setSize(900, 700);
        this.addWindowListener(new UserInterface_this_windowAdapter(this));
        this.getContentPane().setLayout(null);
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.getViewport().setBackground(Color.black);
        this.jScrollPane1.setAutoscrolls(true);
        this.jScrollPane1.setBorder(null);
        this.jScrollPane1.setToolTipText("");
        this.jScrollPane1.setBounds(new Rectangle(173, 414, 520, 195));
        this.jTextArea1.setBackground(new Color(10, 10, 10));
        this.jTextArea1.setEditable(false);
        this.jTextArea1.setText("");
        this.jTextArea1.setColumns(0);
        this.jTextArea1.setLineWrap(true);
        this.jTextArea1.setWrapStyleWord(true);
        this.jTextArea1.setFont(new Font("Kristen ITC", 1, 15));
        this.jTextArea1.setForeground(Color.green);
        this.jTextArea1.setBorder(BorderFactory.createLoweredBevelBorder());
        this.jButton1.setBackground(Color.white);
        this.jButton1.setBounds(new Rectangle(761, 567, 69, 70));
        this.jButton1.setFont(new Font("Dialog", 1, 15));
        this.jButton1.setBorder(null);
        this.jButton1.setToolTipText("Go back");
        this.jButton1.setHorizontalTextPosition(11);
        this.jButton1.setIcon(this.downtIcon);
        this.jButton1.addActionListener(new UserInterface_jButton1_actionAdapter(this));
        this.jButton2.setBackground(Color.black);
        this.jButton2.setBounds(new Rectangle(761, 447, 69, 70));
        this.jButton2.setFont(new Font("Dialog", 1, 15));
        this.jButton2.setForeground(Color.black);
        this.jButton2.setBorder(null);
        this.jButton2.setMaximumSize(new Dimension(50, 50));
        this.jButton2.setMinimumSize(new Dimension(50, 50));
        this.jButton2.setPreferredSize(new Dimension(50, 50));
        this.jButton2.setToolTipText("Go forward");
        this.jButton2.setVerifyInputWhenFocusTarget(true);
        this.jButton2.setIcon(this.upIcon);
        this.jButton2.setText("");
        this.jButton2.addActionListener(new UserInterface_jButton2_actionAdapter(this));
        this.jButton3.setBackground(Color.white);
        this.jButton3.setBounds(new Rectangle(813, 511, 69, 70));
        this.jButton3.setFont(new Font("Dialog", 1, 15));
        this.jButton3.setForeground(Color.black);
        this.jButton3.setBorder(null);
        this.jButton3.setToolTipText("Go right");
        this.jButton3.setIcon(this.rightIcon);
        this.jButton3.setText("");
        this.jButton3.addActionListener(new UserInterface_jButton3_actionAdapter(this));
        this.jButton4.setBackground(Color.white);
        this.jButton4.setBounds(new Rectangle(705, 510, 69, 70));
        this.jButton4.setFont(new Font("Dialog", 1, 15));
        this.jButton4.setForeground(Color.black);
        this.jButton4.setBorder(null);
        this.jButton4.setToolTipText("Go left");
        this.jButton4.setIcon(this.leftIcon);
        this.jButton4.setText("");
        this.jButton4.addActionListener(new UserInterface_jButton4_actionAdapter(this));
        this.jTextField1.setBackground(Color.black);
        this.jTextField1.setFont(new Font("Dialog", 1, 15));
        this.jTextField1.setForeground(Color.red);
        this.jTextField1.setBorder(null);
        this.jTextField1.setCaretColor(Color.white);
        this.jTextField1.setEditable(false);
        this.jTextField1.setText(" >>");
        this.jTextField1.setBounds(new Rectangle(142, 617, 27, 37));
        this.jTextField2.setBackground(Color.darkGray);
        this.jTextField2.setFont(new Font("Kristen ITC", 1, 20));
        this.jTextField2.setForeground(Color.orange);
        this.jTextField2.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jTextField2.setCaretColor(Color.black);
        this.jTextField2.setText("write commands here");
        this.jTextField2.setBounds(new Rectangle(173, 617, 520, 37));
        this.jTextField2.addMouseListener(new UserInterface_jTextField2_mouseAdapter(this));
        this.jTextField2.addActionListener(new UserInterface_jTextField2_actionAdapter(this));
        this.jButton5.addActionListener(new UserInterface_jButton5_actionAdapter(this));
        this.jButton6.setBounds(new Rectangle(33, 530, 69, 70));
        this.jButton6.setBorder(null);
        this.jButton6.setToolTipText("Take");
        this.jButton6.setVerifyInputWhenFocusTarget(true);
        this.jButton6.setIcon(this.takeIcon);
        this.jButton6.setSelected(false);
        this.jButton6.setText("");
        this.jButton6.addActionListener(new UserInterface_jButton6_actionAdapter(this));
        this.jButton7.setBounds(new Rectangle(36, 303, 69, 70));
        this.jButton7.setBorder(null);
        this.jButton7.setToolTipText("Use");
        this.jButton7.setIcon(this.useIcon);
        this.jButton7.setSelected(false);
        this.jButton7.addActionListener(new UserInterface_jButton7_actionAdapter(this));
        this.jLabel2.setBackground(Color.white);
        this.jLabel2.setForeground(Color.white);
        this.jLabel2.setBorder(this.titledBorder1);
        this.jLabel2.setIcon(null);
        this.jLabel2.setIconTextGap(4);
        this.jLabel2.setText("");
        this.jLabel2.setBounds(new Rectangle(706, 64, 170, 250));
        this.jButton5.setBounds(new Rectangle(33, 442, 69, 70));
        this.jButton5.setBorder(null);
        this.jButton5.setToolTipText("Look");
        this.jButton5.setIcon(this.lookIcon);
        this.jButton8.setBounds(new Rectangle(757, 323, 69, 70));
        this.jButton8.setBorder(null);
        this.jButton8.setToolTipText("Talk to");
        this.jButton8.setIcon(this.talkIcon);
        this.jButton8.setPressedIcon(null);
        this.jButton8.setSelected(false);
        this.jButton8.setText("");
        this.jButton8.addActionListener(new UserInterface_jButton8_actionAdapter(this));
        this.jButton9.setBackground(Color.black);
        this.jButton9.setBounds(new Rectangle(777, 519, 36, 48));
        this.jButton9.setFont(new Font("Dialog", 1, 15));
        this.jButton9.setBorder(null);
        this.jButton9.setIcon(this.helpIcon);
        this.jButton9.setText("");
        this.jButton9.addActionListener(new UserInterface_jButton9_actionAdapter(this));
        this.jLabel3.setBackground(Color.black);
        this.jLabel3.setFont(new Font("Kristen ITC", 1, 17));
        this.jLabel3.setForeground(Color.red);
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Inventory");
        this.jLabel3.setBounds(new Rectangle(19, 16, 99, 30));
        this.jList1.setBackground(new Color(30, 30, 30));
        this.jList1.setFont(new Font("Kristen ITC", 1, 15));
        this.jList1.setForeground(Color.yellow);
        this.jList1.setAutoscrolls(true);
        this.jList1.setBorder(BorderFactory.createLoweredBevelBorder());
        this.jList1.setToolTipText("Press CTRL+ for multiple selections");
        this.jList1.setSelectionMode(2);
        this.jList1.setBounds(new Rectangle(12, 55, 118, 224));
        this.jLabel4.setBounds(new Rectangle(715, 16, 157, 30));
        this.jLabel4.setText("Person in room");
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setForeground(Color.red);
        this.jLabel4.setToolTipText("");
        this.jLabel4.setFont(new Font("Kristen ITC", 1, 17));
        this.jLabel4.setBackground(Color.black);
        this.getContentPane().add((Component) this.jLabel1, null);
        this.getContentPane().add((Component) this.jButton1, null);
        this.getContentPane().add((Component) this.jButton2, null);
        this.getContentPane().add((Component) this.jButton9, null);
        this.getContentPane().add((Component) this.jScrollPane1, null);
        this.jScrollPane1.getViewport().add((Component) this.jTextArea1, null);
        this.getContentPane().add((Component) this.jTextField1, null);
        this.getContentPane().add((Component) this.jTextField2, null);
        this.getContentPane().add((Component) this.jLabel3, null);
        this.getContentPane().add((Component) this.jButton3, null);
        this.getContentPane().add((Component) this.jButton4, null);
        this.getContentPane().add((Component) this.jList1, null);
        this.getContentPane().add((Component) this.jButton7, null);
        this.getContentPane().add((Component) this.jButton8, null);
        this.getContentPane().add((Component) this.jLabel2, null);
        this.getContentPane().add((Component) this.jLabel4, null);
        this.getContentPane().add((Component) this.jButton5, null);
        this.getContentPane().add((Component) this.jButton6, null);
    }

    public void println(String s) {
        String temp = this.jTextArea1.getText();
        this.jTextArea1.setText(temp + "\n" + s);
    }

    public void removeListItem(String s) {
        this.inventoryItems.remove(s);
        this.jList1.setListData(this.inventoryItems);
        this.jList1.repaint();
    }

    public void setImage(String commandLine) {
        this.jLabel1.setIcon(new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource(commandLine)));
    }

    public void setPersonImage(String commandLine) {
        this.jLabel2.setIcon(new ImageIcon((class$egoproject$UserInterface == null
                ? (class$egoproject$UserInterface = UserInterface.class$("egoproject.UserInterface"))
                : class$egoproject$UserInterface).getResource(commandLine)));
    }

    void this_windowClosing(WindowEvent e) {
        this.dispose();
    }
}
