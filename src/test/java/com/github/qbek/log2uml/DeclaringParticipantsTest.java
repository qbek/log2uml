package com.github.qbek.log2uml;

import com.github.qbek.log2uml.steps.ParticipantActions;
import com.github.qbek.log2uml.steps.Preconditions;
import com.github.qbek.log2uml.steps.RenderedDiagramQuerys;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class DeclaringParticipantsTest extends ScenarioTest<Preconditions, ParticipantActions, RenderedDiagramQuerys> {

    @Test
    public void johnCanDeclarteActorParticipant () throws IOException {
        given().john_has_diagram();
        when().john_declares_actor_$("Unicorn");
        then().rendered_diagram_contains_line_$("actor Unicorn");
    }

    @Test
    public void johnCanDeclareStandardParticipant () {
        given().john_has_diagram();
        when().john_declares_participant_$("NoName");
        then().rendered_diagram_contains_line_$("participant NoName");
    }

    @Test
    public void johnCanDeclareRenamedParticipant () {
        given().john_has_diagram();
        when().john_declares_actor_$_renamedTo_$("TwoFace", "HappySide");
        then().rendered_diagram_contains_line_$("actor TwoFace as \"HappySide\"");
    }

    @Test
    public void johnCarCreateGroupOfParticipants () {
        given().john_has_diagram();
        when().john_declares_participant_group_$("Village People")
            .and().he_adds_actor_$_to_group("Sam")
            .and().he_adds_actor_$_to_group("Jessica");
        then().rendered_diagram_contains_line_$("box \"Village People\"")
                .and().rendered_diagram_contains_$_on_next_line("actor Sam")
                .and().rendered_diagram_contains_$_on_next_line("actor Jessica")
                .and().rendered_diagram_contains_$_on_next_line("end box");
    }
}
