/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

class Command {
    private String commandWord;
    private String secondWord;
    private String thirdWord;

    public Command(String firstWord, String secondWord, String thirdWord) {
        this.commandWord = firstWord;
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    }

    public String getCommandWord() {
        return this.commandWord;
    }

    public String getSecondWord() {
        return this.secondWord;
    }

    public String getThirdWord() {
        return this.thirdWord;
    }

    public boolean hasSecondWord() {
        return this.secondWord != null;
    }

    public boolean hasThirdWord() {
        return this.thirdWord != null;
    }

    public boolean isUnknown() {
        return this.commandWord == null;
    }
}
