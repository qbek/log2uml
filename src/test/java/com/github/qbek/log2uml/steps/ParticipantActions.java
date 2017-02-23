package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.assets.DiagramUnderTest;
import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Quoted;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class ParticipantActions extends Stage<ParticipantActions> {


    public void john_declares_actor_$ (@Quoted String name) {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.declareActor(name);
    }

    public void john_declares_actor_$_renamedTo_$ (@Quoted String name, @Quoted String rename) {
        SequenceDiagram diagram = DiagramUnderTest.getDUT();
        diagram.declareActor(name).renameTo(rename);
    }
}
