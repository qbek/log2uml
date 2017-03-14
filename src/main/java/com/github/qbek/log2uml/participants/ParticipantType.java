package com.github.qbek.log2uml.participants;

/**
 * Created by Jakub Szewczyk on 07/03/2017.
 */
public enum ParticipantType {
    ACTOR ("actor"),
    PARTICIPANT ("participant"), BOUNDARY("boundary"), CONTROL("control"), ENTITY("entity"), DATABASE("database");

    private String prefix;

    ParticipantType (String prefix) {
        this.prefix = prefix;
    }

    String render () {
        return prefix;
    }
}
