package com.github.qbek.steps;

import com.github.qbek.diagram.SequenceDiagram;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioRule;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jakub on 30/11/2016.
 */
public class DiagramThen extends Stage<DiagramThen> {

    private int lineIndex = 0;
    private ArrayList<String> rendered;

    @ScenarioRule
    Hooks hooks = new Hooks();


    public DiagramThen rendered_diagram_starts_with_opening_tag() {
        lineIndex = 0;
        lineUnderIndexContains("@startuml");
        return self();
    }

    public DiagramThen rendered_diagram_has_in_line(String expected, int line) {
        lineIndex = line - 1;
        lineUnderIndexContains(expected);
        return self();
    }

    public DiagramThen rendered_diagram_has_in_next_line(String expected) {
        lineIndex += 1;
        lineUnderIndexContains(expected);
        return self();
    }

    private void lineUnderIndexContains (String expected) {
        if(rendered == null) {
            rendered = new ArrayList<String>(Arrays.asList(SequenceDiagram.getInstance().render().split("\n")));
        }
        assertThat(rendered.get(lineIndex)).isEqualTo(expected);
    }

    public void rendered_diagram_ends_with_closing_tag() {
        lineIndex = rendered.size() - 1;
        lineUnderIndexContains("@enduml");
    }
}
