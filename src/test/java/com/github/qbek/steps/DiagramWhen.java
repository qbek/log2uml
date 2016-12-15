package com.github.qbek.steps;

import com.github.qbek.bricks.Message;
import com.github.qbek.diagram.SequenceDiagram;
import com.tngtech.jgiven.Stage;

import java.util.ArrayList;

import static com.github.qbek.bricks.Note.On;

/**
 * Created by jakub on 30/11/2016.
 */
public class DiagramWhen extends Stage<DiagramWhen> {

    Message msgUnderConstruction;

    public DiagramWhen john_creates_diagram(String title) {
        SequenceDiagram.createNew(title);
        return self();
    }



    public DiagramWhen john_adds_request_message_$_form_$_to_$(String msg, String sender, String recipient) {
        SequenceDiagram diagram = SequenceDiagram.getInstance();
        diagram.addRequest(msg, sender, recipient);
        return self();
    }

    public DiagramWhen john_adds_response_message_to_diagram(String msg, String sender, String recipient) {
        SequenceDiagram diagram = SequenceDiagram.getInstance();
        diagram.addResponse(msg, sender, recipient);
        return self();
    }

    public DiagramWhen john_adds_sample_message() {
        SequenceDiagram diagram = SequenceDiagram.getInstance();
        msgUnderConstruction = diagram.addRequest("Sample message", "sender", "recipient");
        return self();
    }

    public DiagramWhen john_adds_note_on_left_to_message(String note) {
        msgUnderConstruction.withNote(note, On.LEFT);
        return self();
    }

    public DiagramWhen john_adds_note_on_left_to_message() {
        msgUnderConstruction.withNote(On.LEFT);
        return self();
    }

    public DiagramWhen adds_note_on_right_to_message(String note) {
        msgUnderConstruction.withNote(note, On.RIGHT);
        return self();
    }


    public void john_adds_note_with_table(ArrayList table) {
        msgUnderConstruction.withNote(On.LEFT).addTable(table);
    }

    public void john_adds_note_with_table_with_header(ArrayList table, String[] header) {
        msgUnderConstruction.withNote(On.RIGHT).addTableWithHeader(table, header);
    }
}
