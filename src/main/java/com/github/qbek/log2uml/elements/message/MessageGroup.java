package com.github.qbek.log2uml.elements.message;

import com.github.qbek.log2uml.elements.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Szewczyk on 26/02/2017.
 */
public class MessageGroup implements Element {
    private final String name;
    private List<Message> messages = new ArrayList<>();
    MessageGroup (String name) {
        this.name = name;
    }


    public void add (Message msg) {
        messages.add(msg);
    }


    @Override
    public String render () {
        StringBuilder render = new StringBuilder();
        render.append("group ").append(name).append("\n");
        for(Message msg : messages) {
            render.append(msg.render());
        }
        return render.append("end\n").toString();
    }
}
