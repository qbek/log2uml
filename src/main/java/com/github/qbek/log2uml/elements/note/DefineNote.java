package com.github.qbek.log2uml.elements.note;

/**
 * Created by Jakub Szewczyk on 04/03/2017.
 */
public class DefineNote {

    private final String text;

    private DefineNote (String text) {
        this.text = text;
    }


    public static DefineNote text (String text) {
        return new DefineNote(text);
    }

    public Note position (NotePosition position) {
        return new Note(text, position);
    }
}
