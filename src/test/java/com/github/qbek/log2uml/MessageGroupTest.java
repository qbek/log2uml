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
    public void john_can_create_message_group () {
        given().john_has_diagram();

        when().john_adds_the_message_group_$("good news")
            .and().john_adds_sample_request_to_the_group();

        then().rendered_diagram_contains_line_$("group good news")
            .and().rendered_diagram_contains_sample_request_on_next_line()
            .and().rendered_diagram_contains_line_$("end");
    }

    @Test
    public void john_can_crate_many_message_group_types() {
        given().john_has_diagram();

        when().john_adds_the_optional_message_group_$("Optional Elephant")
            .and().john_adds_the_loop_message_group_$("Looped Situation")
            .and().john_adds_the_parallel_message_group_$("Parallel Circles")
            .and().john_adds_the_break_message_group_$("Lunch Break")
            .and().john_adds_the_critical_message_group_$("Critical Dragon");
        then().rendered_diagram_contains_line_$("opt Optional Elephant")
            .rendered_diagram_contains_line_$("loop Looped Situation")
            .rendered_diagram_contains_line_$("par Parallel Circles")
            .rendered_diagram_contains_line_$("break Lunch Break")
            .rendered_diagram_contains_line_$("critical Critical Dragon");
    }

    @Test
    public void john_can_create_alternative_message_group_with_else() {
        given().john_has_diagram();

        when().john_adds_the_alternative_message_group_$("Alternative Roads")
            .and().john_adds_sample_request_to_the_group()
            .and().john_adds_the_alternative_else_message_group_$("Mainstream Highways")
            .and().jong_adds_sample_response_to_the_group()
            .and().john_adds_the_alternative_else_message_group_$("You are lost")
            .and().john_adds_sample_request_to_the_group();

        then().rendered_diagram_contains_line_$("alt Alternative Roads")
            .and().rendered_diagram_contains_sample_request_on_next_line()
            .and().rendered_diagram_contains_$_on_next_line("else Mainstream Highways")
            .and().rendered_diagram_contains_sample_respones_on_next_line()
            .and().rendered_diagram_contains_$_on_next_line("else You are lost")
            .and().rendered_diagram_contains_sample_request_on_next_line()
            .and().rendered_diagram_contains_$_on_next_line("end");
    }

    @Test
    public void message_message_can_contain_another_group() {
        given().john_has_diagram();

        when().john_adds_the_optional_message_group_$("Optional Elephant")
            .and().john_adds_sample_request_to_the_group()
            .and().john_adds_the_loop_group_to_message_group_$("Looped Situation")
            .and().jong_adds_sample_response_to_the_inner_group();

        then().rendered_diagram_contains_line_$("opt Optional Elephant")
                .and().rendered_diagram_contains_sample_request_on_next_line()
                .and().rendered_diagram_contains_$_on_next_line("loop Looped Situation")
                .and().rendered_diagram_contains_sample_respones_on_next_line()
                .and().rendered_diagram_contains_$_on_next_line("end")
                .and().rendered_diagram_contains_$_on_next_line("end");
    }
}
