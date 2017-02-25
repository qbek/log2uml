package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.assets.DiagramUnderTest;
import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.participants.ParticipantGroup;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Quoted;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class ParticipantActions extends Stage<ParticipantActions> {

    private ParticipantGroup groupUnderTest;

    public ParticipantActions john_declares_actor_$ (@Quoted String name) {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.declareActor(name);
        return self();
    }

    public ParticipantActions john_declares_actor_$_renamedTo_$ (@Quoted String name, @Quoted String rename) {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.declareActor(name).renameTo(rename);
        return self();
    }

    public ParticipantActions john_declares_participant_$ (@Quoted String name) {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.declareParticipant(name);
        return self();
    }

    public ParticipantActions john_declares_participant_group_$ (@Quoted String name) {
        groupUnderTest = SequenceDiagram.createParticipantGroup(name);
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.declareParticipantGroup(groupUnderTest);
        return self();
    }

    public ParticipantActions he_adds_actor_$_to_group (String name) {
        groupUnderTest.declareMember(SequenceDiagram.createActor(name));
        return self();
    }
}
