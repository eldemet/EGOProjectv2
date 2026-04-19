/*
 * Decompiled with CFR 0.152.
 */
package egoproject;

public class People {
    private String iconPath;
    private String talkWords;
    private String whoIs;

    public People(String string, String string1, String string2) {
        this.whoIs = string;
        this.iconPath = string1;
        this.talkWords = string2;
    }

    public People(String string, String string1) {
        this.whoIs = string;
        this.iconPath = string1;
    }

    public People() {
    }

    public String getIconPath() {
        return this.iconPath;
    }

    public String getPeopleWords() {
        return this.talkWords;
    }

    public void setIconPath(String s) {
        this.iconPath = s;
    }

    public void setPeopleWords(String s) {
        this.talkWords = s;
    }
}
