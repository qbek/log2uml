package com.github.qbek.log2uml.diagram;

import com.github.qbek.log2uml.elements.Element;
import net.sourceforge.plantuml.SourceStringReader;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by jakub on 03/09/16.
 */
public abstract class Diagram {


    protected ArrayList<Element> elements = new ArrayList<>();
    protected String title;


    public Diagram (String title) {

        this.title = title;
    }

    public void save (String filename) throws IOException {
        FileOutputStream file = new FileOutputStream(filename.concat(".png"));
        SourceStringReader reader = new SourceStringReader(render());
//        SourceStringReader reader = new SourceStringReader("tet");
        String desc = reader.generateImage(file);
    }

    public String render () {
        StringBuilder rendered = new StringBuilder();
        rendered.append("@startuml\n");
        rendered.append("title ").append(title).append("\n");
        for (Element element : elements) {
            rendered.append(element.render());
        }
        rendered.append("@enduml");
        return rendered.toString();
    }

    public void debug (String filename) throws IOException {
        PrintWriter file = new PrintWriter(filename.concat(".txt"));
        file.write(render());
        file.close();
        System.out.println(render());
    }

    public String getTitle() {
        return title;
    }


}
