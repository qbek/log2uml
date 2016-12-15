package com.github.qbek.bricks;

import com.github.qbek.diagram.SequenceDiagram;

/**
 * Created by jakub on 09/10/16.
 */
public class Message {

    private String message;
    private String from;
    private String to;
    private String type = "->";

    SequenceDiagram diagram;

    private String NEW_LINE = "\n";


    public Message (String message, String from, String to, SequenceDiagram diagram) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.diagram = diagram;
    }

    public Message asRequest () {
        this.type = "->";
        return this;
    }

    public Message asResponse () {
        this.type = "-->";
        return this;
    }

    public String toString() {
        return from.concat(type).concat(to).concat(":").concat(message).concat(NEW_LINE);
    }

    public Note withNote(String note, Note.On side) {
        return this.diagram.addNote(note, side);
    }

    public Note withNote(Note.On side) {
        return this.diagram.addNote(side);
    }
}
