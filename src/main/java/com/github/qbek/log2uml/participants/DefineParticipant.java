package com.github.qbek.log2uml.participants;

/**
 * Created by Jakub Szewczyk on 07/03/2017.
 */
public class DefineParticipant {

    private String name;
    private String rename;

    private DefineParticipant(){};

    public static DefineParticipant name (String name) {
        DefineParticipant definition = new DefineParticipant();
        definition.name = name;
        return definition;
    }

    public Participant type (ParticipantType type) {
        if (rename != null) {
            return new Participant(name, rename, type);
        } else {
            return new Participant(name, type);
        }
    }

    public DefineParticipant renderAs (String rename) {
        this.rename = rename;
        return this;
    }
}
