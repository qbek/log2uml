package com.github.qbek.log2uml.diagram;

import com.github.qbek.log2uml.elements.Element;
import com.github.qbek.log2uml.participants.Participant;
import com.github.qbek.log2uml.participants.ParticipantDeclaration;
import com.github.qbek.log2uml.participants.ParticipantDeclarations;

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

    public static SequenceDiagram withTitle(String title) {
        return new SequenceDiagram(title);
    }

    public SequenceDiagram add (Element el) {
        elements.add(el);
        return this;
    }

    public void declare (ParticipantDeclaration newParticipant) {
        participants.add(newParticipant);
    }
}
