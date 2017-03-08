package com.github.qbek.log2uml;

import com.github.qbek.log2uml.steps.MessageActions;
import com.github.qbek.log2uml.steps.Preconditions;
import com.github.qbek.log2uml.steps.RenderedDiagramQuerys;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 * Created by Jakub Szewczyk on 26/02/2017.
 */
public class MessageGroupTest extends ScenarioTest<Preconditions, MessageActions, RenderedDiagramQuerys> {

    @Test
    public void messageGroupWithCustomName () {
        given().john_has_diagram();

        when().john_adds_the_message_group_$("good news")
            .and().john_adds_sample_request_to_the_group();

        then().rendered_diagram_contains_line_$("group good news")
            .and().rendered_diagram_contains_sample_request_on_next_line()
            .and().rendered_diagram_contains_line_$("end");
    }
}
