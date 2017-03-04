package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.elements.Note;
import com.github.qbek.log2uml.elements.message.DefineMessage;
import com.github.qbek.log2uml.elements.message.MessageType;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;

import java.util.ArrayList;

/**
 * Created by jakub on 30/11/2016.
 */
public class MessageActions extends Stage<MessageActions> {

    @ExpectedScenarioState
    SequenceDiagram diagramUnderTest;

    public MessageActions john_adds_request_message_$_form_$_to_$(@Quoted String msg, String sender, String recipient) {
        diagramUnderTest.add(
                DefineMessage.form(sender).to(recipient).text(msg).type(MessageType.REQUEST)
        );
        return self();
    }

    public MessageActions john_adds_response_message_$_from_$_to_$(@Quoted String msg, String sender, String recipient) {
        diagramUnderTest.add(
                DefineMessage.form(sender).to(recipient).text(msg).type(MessageType.RESPONSE)
        );
        return self();
    }

    public MessageActions john_adds_note_$_on_left_to_message(@Quoted String note) {
        diagramUnderTest.addNote(note, Note.On.LEFT);
        return self();
    }


    public MessageActions john_adds_note_$_on_right_to_message(@Quoted String note) {
        diagramUnderTest.addNote(note, Note.On.RIGHT);
        return self();
    }


    public void john_adds_note_with_table(ArrayList table) {
        diagramUnderTest.addNote(Note.On.LEFT).addTable(table);
    }

    public void john_adds_note_with_table_with_header(ArrayList table, String[] header) {
        diagramUnderTest.addNote(Note.On.RIGHT).addTableWithHeader(table, header);
    }
}
