package com.github.qbek.log2uml.diagram;

import com.github.qbek.log2uml.elements.Element;
import com.github.qbek.log2uml.participants.Participant;
import com.github.qbek.log2uml.participants.ParticipantDeclarations;
import com.github.qbek.log2uml.participants.ParticipantGroup;

/**
 * Created by jakub on 03/09/16.
 */
public class SequenceDiagram extends Diagram {

    private ParticipantDeclarations participants;

    private SequenceDiagram(String title) {
        super(title);
        participants = new ParticipantDeclarations();
    }

    public static SequenceDiagram withTitle(String title) {
        return new SequenceDiagram(title);
    }


    public Participant declareActor (String name) {
        return participants.declareActor(name);
    }

    public Participant declareParticipant (String name) {
        return participants.declareParticipant(name);
    }

    public static ParticipantGroup createParticipantGroup (String name) {
        return new ParticipantGroup(name);
    }

    public void declareParticipantGroup (ParticipantGroup group) {
        participants.declareGroup(group);
    }

    public static Participant createActor (String name) {
        return new Participant(name, Participant.TYPE.actor);
    }

    public SequenceDiagram add (Element el) {
        elements.add(el);
        return this;
    }
}
