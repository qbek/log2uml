package com.github.qbek.log2uml.participants;

/**
 * Created by Jakub Szewczyk on 08/03/2017.
 */
public class DefineParticipantGroup {

    private DefineParticipantGroup () {};

    public static ParticipantGroup name (String name) {
        return new ParticipantGroup(name);
    }
}
