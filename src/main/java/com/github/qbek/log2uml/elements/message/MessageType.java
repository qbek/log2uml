package com.github.qbek.log2uml.elements.message;

/**
 * Created by Jakub Szewczyk on 03/03/2017.
 */
public enum MessageType {
    REQUEST ("->"),
    RESPONSE ("-->");

    private String rendered;

    MessageType (String rendered) {
        this.rendered = rendered;
    }

    String render () {return rendered;}
}
