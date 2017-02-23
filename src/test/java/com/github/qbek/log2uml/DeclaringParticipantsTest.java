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
        given().jonh_has_diagram();
        when().john_declares_actor_$("Unicorn");
        then().rendered_diagram_contains_line_$("actor \"Unicorn\"");

        when().john_declares_actor_$_renamedTo_$("TwoFace", "HappySide");
        then().rendered_diagram_contains_line_$("actor \"TwoFace\" as \"HappySide\"");
    }
}
