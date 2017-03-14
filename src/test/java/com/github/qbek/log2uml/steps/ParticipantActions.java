package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.participants.DefineParticipant;
import com.github.qbek.log2uml.participants.DefineParticipantGroup;
import com.github.qbek.log2uml.participants.ParticipantGroup;
import com.github.qbek.log2uml.participants.ParticipantType;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;


/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class ParticipantActions extends Stage<ParticipantActions> {

    private ParticipantGroup groupUnderTest;

    @ExpectedScenarioState
    SequenceDiagram diagramUnderTest;

    public ParticipantActions john_declares_actor_$ (@Quoted String name) {
        diagramUnderTest.declare(DefineParticipant.name(name).type(ParticipantType.ACTOR));
        return self();
    }

    public ParticipantActions john_declares_actor_$_renamedTo_$ (@Quoted String name, @Quoted String rename) {
        diagramUnderTest.declare(DefineParticipant.name(name).renderAs(rename).type(ParticipantType.ACTOR));
        return self();
    }

    public ParticipantActions john_declares_participant_$ (@Quoted String name) {
        diagramUnderTest.declare(DefineParticipant.name(name).type(ParticipantType.PARTICIPANT));
        return self();
    }

    public ParticipantActions john_declares_boundary_$ (@Quoted String name) {
        diagramUnderTest.declare(DefineParticipant.name(name).type(ParticipantType.BOUNDARY));
        return self();
    }

    public ParticipantActions john_declares_control_$ (@Quoted String name) {
        diagramUnderTest.declare(DefineParticipant.name(name).type(ParticipantType.CONTROL));
        return self();
    }

    public ParticipantActions john_declares_entity_$ (@Quoted String name) {
        diagramUnderTest.declare(DefineParticipant.name(name).type(ParticipantType.ENTITY));
        return self();
    }

    public ParticipantActions john_declares_database_$ (@Quoted String name) {
        diagramUnderTest.declare(DefineParticipant.name(name).type(ParticipantType.DATABASE));
        return self();
    }

    public ParticipantActions john_declares_participant_group_$ (@Quoted String name) {
        groupUnderTest = DefineParticipantGroup.name(name);
        diagramUnderTest.declare(groupUnderTest);
        return self();
    }

    public ParticipantActions he_adds_actor_$_to_group (String name) {
        groupUnderTest.declareMember(
                DefineParticipant.name(name).type(ParticipantType.ACTOR)
        );
        return self();
    }



}
