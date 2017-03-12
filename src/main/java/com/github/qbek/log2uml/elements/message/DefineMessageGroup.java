package com.github.qbek.log2uml.elements.message;

/**
 * Created by Jakub Szewczyk on 06/03/2017.
 */
public class DefineMessageGroup {


    private String name;

    public static DefineMessageGroup name (String name) {
        DefineMessageGroup define = new DefineMessageGroup();
        define.name = name;
        return define;
    }

    public MessageGroup type(MessageGroupType type) {
        return new MessageGroup(name, type);
    }
}
