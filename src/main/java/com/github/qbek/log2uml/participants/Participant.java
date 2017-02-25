package com.github.qbek.log2uml.participants;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class Participant extends ParticipantDeclaration {


    private String rename = "";
    private TYPE type;

    public static enum TYPE {
        participant, actor
    }

    public Participant (String name, TYPE type) {
        super(name);
        this.type = type;
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
