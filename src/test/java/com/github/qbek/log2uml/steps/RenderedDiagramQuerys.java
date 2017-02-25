package com.github.qbek.log2uml.steps;

import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Quoted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jakub Szewczyk on 23/02/2017.
 */
public class RenderedDiagramQuerys extends Stage<RenderedDiagramQuerys> {
    private int lastQueriedline;

    @ExpectedScenarioState
    SequenceDiagram diagramUnderTest;

    public RenderedDiagramQuerys rendered_diagram_contains_line_$ (@Quoted String expected) {
        String render = diagramUnderTest.render();
        assertThat(render).contains(expected +"\n");
        lastQueriedline = searchLastQueriedLine(expected);
        return self();
    }

    public RenderedDiagramQuerys rendered_diagram_starts_with_opening_tag() {
        List<String> renderedLines = getRenderAsLines();
        assertThat(renderedLines.get(0)).contains("@startuml");
        return self();
    }

    public RenderedDiagramQuerys rendered_diagram_ends_with_closing_tag() {
        List<String> renderedLines = getRenderAsLines();
        int lastLine = renderedLines.size() - 1;
        assertThat(renderedLines.get(lastLine)).contains("@enduml");
        return self();
    }

    public RenderedDiagramQuerys rendered_diagram_contains_on_next_line_$ (@Quoted String expected) {
        assertNextLine(expected);
        lastQueriedline++;
        return self();
    }

    private void assertNextLine (String expected) {
        List<String> renderedLines = getRenderAsLines();
        assertThat(renderedLines.get(lastQueriedline + 1)).contains(expected);
    }

    private int searchLastQueriedLine (String searchPattern) {
        List<String> renderedLines = getRenderAsLines();
        for(int i=0; i < renderedLines.size(); i++) {
            if (renderedLines.get(i).contains(searchPattern)) {
                return  i;
            }
        }
        return 0;
    }

    private ArrayList<String> getRenderAsLines () {
        return new ArrayList<>(Arrays.asList(diagramUnderTest.render().split("\n")));
    }


}
