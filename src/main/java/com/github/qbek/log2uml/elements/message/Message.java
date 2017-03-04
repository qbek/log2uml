package com.github.qbek.log2uml.elements.message;

import com.github.qbek.log2uml.elements.Element;

/**
 * Created by jakub on 09/10/16.
 */
public class Message implements Element {

    private String message;
    private String from;
    private String to;
    private MessageType type;

    Message (String message, String from, String to, MessageType type) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.type = type;
    }

    @Override
    public String render () {
        return from.concat(type.render()).concat(to).concat(":").concat(message).concat("\n");
    }
}
