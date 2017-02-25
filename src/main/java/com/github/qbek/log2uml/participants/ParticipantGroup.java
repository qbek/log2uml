package com.github.qbek.log2uml.participants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Szewczyk on 25/02/2017.
 */
public class ParticipantGroup  extends ParticipantDeclaration {

    private List<ParticipantDeclaration> members = new ArrayList<>();

    public ParticipantGroup (String name) {
        super(name);
    }

    public ParticipantDeclaration declareMember (ParticipantDeclaration member) {
        members.add(member);
        return member;
    }
    public String toString() {
        StringBuilder output = new StringBuilder("box ").append(name).append("\n");
        for (ParticipantDeclaration member : members) {
            output.append(member);
        }
        return output.append("end box\n").toString();
    }
}
