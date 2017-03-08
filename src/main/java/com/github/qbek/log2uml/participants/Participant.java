package com.github.qbek.log2uml.participants;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class Participant extends ParticipantDeclaration {

    private String rename;
    private ParticipantType type;


    Participant (String name, ParticipantType type) {
        super(name);
        this.type = type;
    }

    Participant (String name, String rename, ParticipantType type) {
        super(name);
        this.rename = String.format("\"%s\"", rename);
        this.type = type;
    }


    @Override
    public String render () {
        String output = renderNamePart();
        output = addRenamePart(output);
        return output.concat("\n");
    }

    private String renderNamePart () {
        return String.format("%s %s", type.render(), name);
    }

    private String addRenamePart (String output) {
        if (rename != null) {
            return output.concat(" as ").concat(rename);
        } else {
            return output;
        }
    }

}
