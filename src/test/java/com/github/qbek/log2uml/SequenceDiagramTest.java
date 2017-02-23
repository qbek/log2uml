package com.github.qbek.log2uml;

import com.github.qbek.log2uml.steps.DiagramGiven;
import com.github.qbek.log2uml.steps.DiagramThen;
import com.github.qbek.log2uml.steps.DiagramWhen;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class SequenceDiagramTest extends ScenarioTest<DiagramGiven, DiagramWhen, DiagramThen> {

    @Test
    public void diagramHasATitle () throws IOException {
        when().john_creates_diagram_with_title("Title_test");
        then().rendered_diagram_starts_with_opening_tag()
                .rendered_diagram_has_text_$_on_line_$("title ".concat("Title_test"), 2)
                .rendered_diagram_ends_with_closing_tag();

    }

    @Test
    public void diagramRequestAndRespons () throws IOException {
        when().john_creates_diagram_with_title("Request_and_response")
                .john_adds_request_message_$_form_$_to_$("test request", "sender", "recipient")
                .john_adds_response_message_$_from_$_to_$("test response", "recipient", "sender");


        then().rendered_diagram_has_text_$_on_line_$("sender->recipient:test request", 3)
                .rendered_diagram_has_text_$_on_next_line("recipient-->sender:test response");

    }

    @Test
    public void diagramMessageCanHaveNote() throws IOException {
        when().john_creates_diagram_with_title("Message_notes")
                .john_adds_sample_message()
                .john_adds_note_$_on_left_to_message("Test note on left")
                .john_adds_sample_message()
                .john_adds_note_$_on_right_to_message("Test note on right");

        then().rendered_diagram_has_text_$_on_line_$("note left", 4)
                .rendered_diagram_has_text_$_on_next_line("Test note on left")
                .rendered_diagram_has_text_$_on_next_line("end note")
                .rendered_diagram_has_text_$_on_line_$("note right", 8)
                .rendered_diagram_has_text_$_on_next_line("Test note on right")
                .rendered_diagram_has_text_$_on_next_line("end note");

    }

    @Test
    public void noteCanHaveTable() {
        ArrayList<String[]> table = new ArrayList<String[]>();
        table.add(new String[]{"row 1.a", "row 1.b", "row 1.c"});
        table.add(new String[]{"row 2.a", "row 2.b", "row 2.c"});
        table.add(new String[]{"row 3.a", "row 3.b", "row 3.c"});

        when().john_creates_diagram_with_title("Note_can_have_table")
                .john_adds_sample_message()
                .john_adds_note_with_table(table);

        then().rendered_diagram_has_text_$_on_line_$("| row 1.a | row 1.b | row 1.c |", 5)
            .rendered_diagram_has_text_$_on_next_line("| row 2.a | row 2.b | row 2.c |")
            .rendered_diagram_has_text_$_on_next_line("| row 3.a | row 3.b | row 3.c |");
    }

    @Test
    public void tableCanHaveHeader() {
        ArrayList<String[]> table = new ArrayList<String[]>();
        table.add(new String[]{"row 1.a", "row 1.b", "row 1.c"});

        when().john_creates_diagram_with_title("Note_can_have_table_with_header")
                .john_adds_sample_message()
                .john_adds_note_with_table_with_header(table, new String[]{"header 1", "header 2", "header 3"});

        then().rendered_diagram_has_text_$_on_line_$("|= header 1 |= header 2 |= header 3 |", 5)
                .rendered_diagram_has_text_$_on_next_line("| row 1.a | row 1.b | row 1.c |");
    }
}