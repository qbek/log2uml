package com.github.qbek.log2uml.diagram;

import net.sourceforge.plantuml.SourceStringReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jakub on 03/09/16.
 */
public abstract class Diagram {


    protected static StringBuilder rendered;
    protected List diagramElements = new ArrayList<Object>();
    protected String title;



    protected void log (String log) {
        rendered.append(log + "\n");
    }

    public Diagram (String title) {
        rendered = new StringBuilder();
        this.title = title;
        log("@startuml");
        log("title " + title);
    }

    public void save (FileOutputStream outputFile) throws IOException {
        SourceStringReader reader = new SourceStringReader(render());
//        SourceStringReader reader = new SourceStringReader("tet");
        String desc = reader.generateImage(outputFile);
    }

    public String render () {
        for (int i=0; i < diagramElements.size();i++) {
            rendered.append(diagramElements.get(i));
        }
        rendered.append("@enduml");
        return rendered.toString();
    }

    public String getTitle() {
        return title;
    }
}
