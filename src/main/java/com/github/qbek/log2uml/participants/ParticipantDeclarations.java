package com.github.qbek.log2uml.participants;

import com.github.qbek.log2uml.elements.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class ParticipantDeclarations implements Element {

    private List<ParticipantDeclaration> declarations = new ArrayList<>();

    public void add (ParticipantDeclaration participant) {
        declarations.add(participant);
    }

    @Override
    public String render () {
        StringBuilder output = new StringBuilder();
        for (ParticipantDeclaration declaration : declarations) {
            output.append(declaration.render());
        }
        return output.append("\n").toString();
    }
}
