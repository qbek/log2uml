package com.github.qbek.log2uml.assets;

import com.github.qbek.log2uml.diagram.SequenceDiagram;

/**
 * Created by Jakub Szewczyk on 21/02/2017.
 */
public class DiagramUnderTest {

    private static SequenceDiagram dut;

    public static SequenceDiagram getDUT() {
        return dut;
    }

    public static void setDUT(SequenceDiagram dut) {
        DiagramUnderTest.dut = dut;
    }
}
