package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.assets.DiagramUnderTest;
import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.tngtech.jgiven.Stage;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class Preconditions extends Stage<Preconditions> {

    public void jonh_has_diagram() {
        DiagramUnderTest.setDUT(SequenceDiagram.withTitle("Awesome test diagram"));
    }
}
