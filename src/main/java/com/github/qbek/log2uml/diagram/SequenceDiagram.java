package com.github.qbek.log2uml.diagram;

import com.github.qbek.log2uml.bricks.Message;
import com.github.qbek.log2uml.bricks.Note;
import com.github.qbek.log2uml.participants.Participant;
import com.github.qbek.log2uml.participants.ParticipantsDeclarations;

/**
 * Created by jakub on 03/09/16.
 */
public class SequenceDiagram extends Diagram {

    private static String END_NOTE = "end note";
    private static String START_NOTE = "note left";

    private ParticipantsDeclarations participants;

    private SequenceDiagram(String title) {
        super(title);
        participants = new ParticipantsDeclarations();
        diagramElements.add(participants);
    }

    public static SequenceDiagram withTitle(String title) {
        return new SequenceDiagram(title);
    }

    private Message addMessage(String message, String from, String to) {
        Message msg = new Message(message, from, to, this);
        diagramElements.add(msg);
        return msg;
    }

    public Message addRequest(String msg, String from, String to) {
        return this.addMessage(msg, from, to).asRequest();
    }

    public Note addNote(String text, Note.On side) {
        Note note = new Note(text, side);
        diagramElements.add(note);
        return note;
    }

    public Note addNote(Note.On side) {
        Note note = new Note(side);
        diagramElements.add(note);
        return note;
    }

    public Message addResponse(String msg, String from, String to) {
        return this.addMessage(msg, from, to).asResponse();
    }

    public Participant declareActor (String name) {
        return participants.declareActor(name);
    }
}
