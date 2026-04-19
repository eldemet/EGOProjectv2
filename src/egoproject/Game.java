/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.GameEngine;
import egoproject.UserInterface;

public class Game {
    private GameEngine engine = new GameEngine();
    private UserInterface gui = new UserInterface(this.engine);

    public Game() {
        this.engine.setGUI(this.gui);
    }

    public static void main(String[] args) {
        Game ga = new Game();
    }
}
