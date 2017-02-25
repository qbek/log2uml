package com.github.qbek.log2uml.participants;

/**
 * Created by Jakub Szewczyk on 25/02/2017.
 */
public abstract class ParticipantDeclaration {
    protected String name;

    public ParticipantDeclaration (String name) {
        this.name = String.format("\"%s\"", name);
    }


}
