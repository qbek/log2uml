package com.github.qbek.log2uml;

import com.github.qbek.log2uml.steps.MessageActions;
import com.github.qbek.log2uml.steps.Preconditions;
import com.github.qbek.log2uml.steps.RenderedDiagramQuerys;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SequenceDiagramMessageTests extends ScenarioTest<Preconditions, MessageActions, RenderedDiagramQuerys> {

    @Test
    public void diagramHasATitle () throws IOException {
        given().jonh_has_diagram();
        then().rendered_diagram_starts_with_opening_tag()
            .and().rendered_diagram_contains_line_$("title Awesome test diagram")
            .and().rendered_diagram_ends_with_closing_tag();

    }

    @Test
    public void diagramRequestAndRespons () throws IOException {
        given().jonh_has_diagram();
        when().john_adds_request_message_$_form_$_to_$("test request", "sender", "recipient")
            .and().john_adds_response_message_$_from_$_to_$("test response", "recipient", "sender");
        then().rendered_diagram_contains_line_$("sender->recipient:test request")
            .and().rendered_diagram_contains_on_next_line_$("recipient-->sender:test response");
    }

    @Test
    public void diagramMessageCanHaveNote() throws IOException {
        given().jonh_has_diagram();
        when().john_adds_note_$_on_left_to_message("Test note on left");
        then().rendered_diagram_contains_line_$("note left")
            .and().rendered_diagram_contains_on_next_line_$("Test note on left")
            .and().rendered_diagram_contains_on_next_line_$("end note");

        when().and().john_adds_note_$_on_right_to_message("Test note on right");
        then().rendered_diagram_contains_line_$("note right")
            .and().rendered_diagram_contains_on_next_line_$("Test note on right")
            .and().rendered_diagram_contains_on_next_line_$("end note");
    }

    @Test
    public void noteCanHaveTable() {
        ArrayList<String[]> table = new ArrayList<String[]>();
        table.add(new String[]{"row 1.a", "row 1.b", "row 1.c"});
        table.add(new String[]{"row 2.a", "row 2.b", "row 2.c"});
        table.add(new String[]{"row 3.a", "row 3.b", "row 3.c"});

        given().jonh_has_diagram();
        when().john_adds_note_with_table(table);
        then().rendered_diagram_contains_line_$("| row 1.a | row 1.b | row 1.c |")
            .and().rendered_diagram_contains_on_next_line_$("| row 2.a | row 2.b | row 2.c |")
            .and().rendered_diagram_contains_on_next_line_$("| row 3.a | row 3.b | row 3.c |");
    }

    @Test
    public void tableCanHaveHeader() {
        ArrayList<String[]> table = new ArrayList<String[]>();
        table.add(new String[]{"row 1.a", "row 1.b", "row 1.c"});

        given().jonh_has_diagram();
        when().john_adds_note_with_table_with_header(table, new String[]{"header 1", "header 2", "header 3"});
        then().rendered_diagram_contains_line_$("|= header 1 |= header 2 |= header 3 |")
                .and().rendered_diagram_contains_on_next_line_$("| row 1.a | row 1.b | row 1.c |");
    }
}