package com.github.qbek.diagram;

import com.github.qbek.bricks.Message;
import com.github.qbek.bricks.Note;

/**
 * Created by jakub on 03/09/16.
 */
public class SequenceDiagram extends Diagram {

    private static String END_NOTE = "end note";
    private static String START_NOTE = "note left";

    static SequenceDiagram instance;

    private SequenceDiagram(String title) {
        super(title);
    }

    public static SequenceDiagram getInstance() { return instance; }

    public static SequenceDiagram createNew(String title) {
        instance = new SequenceDiagram(title);
        return instance;
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
}
