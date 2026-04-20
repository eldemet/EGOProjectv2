/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.GameEngine;
import egoproject.SplashWindow;
import egoproject.UserInterface;
import javax.swing.SwingUtilities;

public class Game {
    private GameEngine engine = new GameEngine();
    private UserInterface gui = new UserInterface(this.engine);

    public Game() {
        this.engine.setGUI(this.gui);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                SplashWindow splash = new SplashWindow("res/egoproject/img/dland.png", "res/egoproject/mid/dland_splash.mid",
                        new Runnable() {

                    public void run() {
                        new Game();
                    }
                });
                splash.showSplash();
            }
        });
    }
}
