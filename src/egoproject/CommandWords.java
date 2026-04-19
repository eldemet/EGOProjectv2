/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

public class CommandWords {
    private static final String[] validCommands = new String[]{"go", "quit", "help", "take", "talk", "use", "look"};

    public boolean isCommand(String aString) {
        int i = 0;
        while (i < validCommands.length) {
            if (validCommands[i].equals(aString)) {
                return true;
            }
            ++i;
        }
        return false;
    }

    public String showAll() {
        StringBuffer commands = new StringBuffer();
        int i = 0;
        while (i < validCommands.length) {
            commands.append(validCommands[i] + "  ");
            ++i;
        }
        return commands.toString();
    }
}
