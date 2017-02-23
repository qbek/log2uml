package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.assets.DiagramUnderTest;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Quoted;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class RenderedDiagramQuerys extends Stage<RenderedDiagramQuerys> {
    public void rendered_diagram_contains_line_$ (@Quoted String expected) {
        String render = DiagramUnderTest.getDUT().render();
        assertThat(render).contains(expected +"\n");
    }
}
