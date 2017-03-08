package com.github.qbek.log2uml.elements.message;

/**
 * Created by Jakub Szewczyk on 06/03/2017.
 */
public class DefineMessageGroup {
    public static MessageGroup name (String name) {
        return new MessageGroup(name);
    }
}
