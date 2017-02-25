package com.github.qbek.log2uml.participants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class ParticipantDeclarations {

    private List<ParticipantDeclaration> declarations = new ArrayList<>();

    public Participant declareActor (String name) {
        Participant a = new Participant(name, Participant.TYPE.actor);
        declarations.add(a);
        return a;
    }

    public Participant declareParticipant (String name) {
        Participant p = new Participant(name, Participant.TYPE.participant);
        declarations.add(p);
        return p;
    }

    public String toString () {
        StringBuilder output = new StringBuilder();
        for (ParticipantDeclaration declaration : declarations) {
            output.append(declaration);
        }
        return output.append("\n").toString();
    }

    public ParticipantGroup declareGroup (ParticipantGroup group) {
        declarations.add(group);
        return group;
    }
}
