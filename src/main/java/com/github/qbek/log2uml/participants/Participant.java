package com.github.qbek.log2uml.participants;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class Participant {

    private String name;
    private String rename = "";
    private TYPE type;

    public static enum TYPE {
        actor
    }

    Participant (String name, TYPE type) {
        this.type = type;
        this.name = String.format("\"%s\"", name);
    }

    public void renameTo (String rename) {
        this.rename = String.format("\"%s\"", rename);
    }

    public String toString () {
        String output = String.format("%s %s", type.toString(), name);
        if (rename.length() > 0) {
            return output.concat(" as ").concat(rename);
        }
        return output.concat("\n");
    }
}
