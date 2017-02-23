package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.assets.DiagramUnderTest;
import com.github.qbek.log2uml.bricks.Message;
import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.bricks.Note;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Quoted;

import java.util.ArrayList;

/**
 * Created by jakub on 30/11/2016.
 */
public class DiagramWhen extends Stage<DiagramWhen> {

    Message msgUnderConstruction;

    public DiagramWhen john_creates_diagram_with_title(@Quoted String title) {
        SequenceDiagram dut = SequenceDiagram.withTitle(title);
        DiagramUnderTest.setDUT(dut);
        return self();
    }



    public DiagramWhen john_adds_request_message_$_form_$_to_$(@Quoted String msg, String sender, String recipient) {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.addRequest(msg, sender, recipient);
        return self();
    }

    public DiagramWhen john_adds_response_message_$_from_$_to_$(@Quoted String msg, String sender, String recipient) {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.addResponse(msg, sender, recipient);
        return self();
    }

    public DiagramWhen john_adds_sample_message() {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        msgUnderConstruction = diagram.addRequest("Sample message", "sender", "recipient");
        return self();
    }

    public DiagramWhen john_adds_note_$_on_left_to_message(@Quoted String note) {
        msgUnderConstruction.withNote(note, Note.On.LEFT);
        return self();
    }


    public DiagramWhen john_adds_note_$_on_right_to_message(@Quoted String note) {
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
