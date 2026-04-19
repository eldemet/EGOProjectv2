/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

import egoproject.Command;
import egoproject.CommandWords;
import java.util.StringTokenizer;

public class Parser {
    private CommandWords commands = new CommandWords();

    public Command getCommand(String inputLine) {
        StringTokenizer tokenizer = new StringTokenizer(inputLine);
        String word1 = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
        String word2 = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
        String word3 = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : null;
        if (this.commands.isCommand(word1)) {
            return new Command(word1, word2, word3);
        }
        return new Command(null, word2, word3);
    }

    public String showCommands() {
        return this.commands.showAll();
    }
}
