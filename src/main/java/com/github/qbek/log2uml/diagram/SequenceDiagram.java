package com.github.qbek.log2uml.diagram;

import com.github.qbek.log2uml.elements.Element;
import com.github.qbek.log2uml.participants.ParticipantDeclaration;
import com.github.qbek.log2uml.participants.ParticipantDeclarations;

import java.util.Collections;

/**
 * Created by jakub on 03/09/16.
 */
public class SequenceDiagram extends Diagram {

    private ParticipantDeclarations participants;

    private SequenceDiagram(String title) {
        super(title);
        participants = new ParticipantDeclarations();
        elements.add(participants);
    }

    public static SequenceDiagram title (String title) {
        return new SequenceDiagram(title);
    }

    public SequenceDiagram add (Element... elements) {
        Collections.addAll(this.elements, elements);
        return this;
    }

    public void declare (ParticipantDeclaration... declarations) {
        for(ParticipantDeclaration newParticipant : declarations) {
            participants.add(newParticipant);
        }
    }
}
