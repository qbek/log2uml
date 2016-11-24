package com.github.qbek.bricks;

/**
 * Created by jakub on 09/10/16.
 */
public class Message {

    private String message;
    private String from;
    private String to;
    private String type;

    private String NEW_LINE = "\n";

    public Message (String message) {
        this.message = message;
    }

    public Message from (String from) {
        this.from = from;
        return this;
    }

    public Message to (String to) {
        this.to = to;
        return this;
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

}
