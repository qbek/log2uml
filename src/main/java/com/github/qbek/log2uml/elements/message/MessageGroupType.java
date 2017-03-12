package com.github.qbek.log2uml.elements.message;

/**
 * Created by Jakub Szewczyk on 11/03/2017.
 */
public enum MessageGroupType {
    GROUP ("group"),
    OPT ("opt"), LOOP("loop"), PARALLEL("par"), BREAK("break"), CRITICAL("critical"), ALTERNATIVE("alt"), ELSE("else");

    private final String rendered;

    MessageGroupType (String rendered) {
        this.rendered = rendered;
    }

    String render () {return rendered;}
}
