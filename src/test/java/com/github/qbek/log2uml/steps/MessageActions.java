package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.elements.message.*;
import com.github.qbek.log2uml.elements.note.DefineNote;
import com.github.qbek.log2uml.elements.note.NotePosition;
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
    MessageGroup recentlyCreatedMessageGroup;
    MessageGroup alternativeMessageGroup;


    private MessageGroup innerGroupUnderTest;

    public MessageActions john_adds_request_message_$_form_$_to_$(@Quoted String msg, String sender, String recipient) {
        diagramUnderTest.add(
                DefineMessage.from(sender).to(recipient).text(msg).type(MessageType.REQUEST)
        );
        return self();
    }

    public MessageActions john_adds_response_message_$_from_$_to_$(@Quoted String msg, String sender, String recipient) {
        diagramUnderTest.add(
                DefineMessage.from(sender).to(recipient).text(msg).type(MessageType.RESPONSE)
        );
        return self();
    }

    public MessageActions john_adds_note_$_on_left_to_message(@Quoted String note) {
        diagramUnderTest.add(
                DefineNote.text(note).position(NotePosition.LEFT)
        );
        return self();
    }


    public MessageActions john_adds_note_$_on_right_to_message(@Quoted String note) {
        diagramUnderTest.add(
                DefineNote.text(note).position(NotePosition.RIGHT)
        );
        return self();
    }


    public void john_adds_note_with_table(ArrayList table) {
//        diagramUnderTest.addNote(Note.On.LEFT).addTable(table);
    }

    public void john_adds_note_with_table_with_header(ArrayList table, String[] header) {
//        diagramUnderTest.addNote(Note.On.RIGHT).addTableWithHeader(table, header);
    }

    public MessageActions john_adds_the_message_group_$ (String name) {
        defineMsgGroupUnderTest(name, MessageGroupType.GROUP);
        return self();
    }

    public MessageActions john_adds_sample_request_to_the_group () {
        recentlyCreatedMessageGroup.add(DefineMessage.from("sender").to("recipient").text("sample request").type(MessageType.REQUEST));
        return self();
    }

    public MessageActions jong_adds_sample_response_to_the_group () {
        recentlyCreatedMessageGroup.add(DefineMessage.from("Funny Bunny").to("Heavy Armor").text("Hasta la vista, baby!").type(MessageType.REQUEST));
        return self();
    }

    public MessageActions john_adds_the_optional_message_group_$ (String name) {
        defineMsgGroupUnderTest(name, MessageGroupType.OPT);
        return self();
    }

    public MessageActions john_adds_the_loop_message_group_$ (String name)
    {
        defineMsgGroupUnderTest(name, MessageGroupType.LOOP);
        return self();
    }

    public MessageActions john_adds_the_parallel_message_group_$ (String name) {
        defineMsgGroupUnderTest(name, MessageGroupType.PARALLEL);
        return self();
    }

    public MessageActions john_adds_the_break_message_group_$ (String name) {
        defineMsgGroupUnderTest(name, MessageGroupType.BREAK);
        return self();
    }

    public MessageActions john_adds_the_critical_message_group_$ (String name) {
        defineMsgGroupUnderTest(name, MessageGroupType.CRITICAL);
        return self();
    }

    public MessageActions john_adds_the_alternative_message_group_$ (String name) {
        alternativeMessageGroup = defineMsgGroupUnderTest(name, MessageGroupType.ALTERNATIVE);
        return self();
    }

    public MessageActions john_adds_the_alternative_else_message_group_$ (String name) {
        recentlyCreatedMessageGroup = DefineMessageGroup.name(name).type(MessageGroupType.ELSE);
        alternativeMessageGroup.add(recentlyCreatedMessageGroup);
        return self();
    }


    public MessageActions john_adds_the_loop_group_to_message_group_$ (String name) {
        innerGroupUnderTest = DefineMessageGroup.name(name).type(MessageGroupType.LOOP);
        recentlyCreatedMessageGroup.add(innerGroupUnderTest);
        return self();
    }

    public MessageActions jong_adds_sample_response_to_the_inner_group () {
        innerGroupUnderTest.add(DefineMessage.from("Funny Bunny").to("Heavy Armor").text("Hasta la vista, baby!").type(MessageType.REQUEST));
        return self();
    }

    private MessageGroup defineMsgGroupUnderTest (String name, MessageGroupType type) {
        recentlyCreatedMessageGroup = DefineMessageGroup.name(name).type(type);
        diagramUnderTest.add(recentlyCreatedMessageGroup);
        return recentlyCreatedMessageGroup;
    }
}
