package com.github.qbek.log2uml.participants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Szewczyk on 25/02/2017.
 */
public class ParticipantGroup  extends ParticipantDeclaration {

    private List<ParticipantDeclaration> members = new ArrayList<>();

    ParticipantGroup (String name) {
        super(String.format("\"%s\"", name));
    }

    @Override
    public String render () {
        StringBuilder output = new StringBuilder(String.format("box %s\n", name));
        for (ParticipantDeclaration member : members) {
            output.append(member.render());
        }
        return output.append("end box\n").toString();
    }

    public ParticipantDeclaration declareMember (ParticipantDeclaration member) {
        members.add(member);
        return member;
    }
}
