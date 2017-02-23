package com.github.qbek.log2uml.participants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class ParticipantsDeclarations {

    private List<Participant> declarations = new ArrayList<>();

    public Participant declareActor (String name) {
        Participant a = new Participant(name, Participant.TYPE.actor);
        declarations.add(a);
        return a;
    }

    public String toString () {
        StringBuilder output = new StringBuilder();
        for (Participant declaration : declarations) {
            output.append(declaration);
        }
        return output.append("\n").toString();
    }
}
