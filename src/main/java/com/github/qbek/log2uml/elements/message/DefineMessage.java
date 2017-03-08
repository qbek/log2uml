package com.github.qbek.log2uml.elements.message;

/**
 * Created by Jakub Szewczyk on 03/03/2017.
 */
public class DefineMessage {

    private String sender;
    private String recipient;
    private String text;

    public static DefineMessage form (String sender) {
        DefineMessage factory = new DefineMessage();
        factory.sender = sender;
        return factory;
    }

    public DefineMessage to (String recipient) {
        this.recipient = recipient;
        return this;
    }

    public DefineMessage text (String text) {
        this.text = text;
        return this;
    }

    public Message type (MessageType type) {
        return new Message(text, sender, recipient, type);
    }
}
