package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class Preconditions extends Stage<Preconditions> {

    @ProvidedScenarioState
    SequenceDiagram diagramUnderTest;

    public void jonh_has_diagram() {
        diagramUnderTest = SequenceDiagram.withTitle("Awesome test diagram");
//        DiagramUnderTest.setDUT(SequenceDiagram.withTitle("Awesome test diagram"));
    }

}
