package com.github.qbek.log2uml.elements.note;

/**
 * Created by Jakub Szewczyk on 04/03/2017.
 */
public enum NotePosition {
    LEFT ("left"),
    RIGHT ("right");
//    OVER ("over");

    private String rendered;

    NotePosition (String rendered) {
        this.rendered = rendered;
    }

    String render () { return rendered; }

}
