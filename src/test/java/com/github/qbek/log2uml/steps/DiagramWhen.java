package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.bricks.Message;
import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.bricks.Note;
import com.tngtech.jgiven.Stage;

import java.util.ArrayList;

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
        msgUnderConstruction.withNote(note, Note.On.LEFT);
        return self();
    }

    public DiagramWhen john_adds_note_on_left_to_message() {
        msgUnderConstruction.withNote(Note.On.LEFT);
        return self();
    }

    public DiagramWhen adds_note_on_right_to_message(String note) {
        msgUnderConstruction.withNote(note, Note.On.RIGHT);
        return self();
    }


    public void john_adds_note_with_table(ArrayList table) {
        msgUnderConstruction.withNote(Note.On.LEFT).addTable(table);
    }

    public void john_adds_note_with_table_with_header(ArrayList table, String[] header) {
        msgUnderConstruction.withNote(Note.On.RIGHT).addTableWithHeader(table, header);
    }
}
