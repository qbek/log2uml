package com.github.qbek.bricks;

import com.github.qbek.bricks.glues.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 09/10/16.
 */
public class Note {

    String openTag = "note";
    String closeTag = "end note";
    private List<Object> elements = new ArrayList();

    public Note(String text, On side) {
        elements.add(text);
        setOpeningTag(side);
    }

    private void setOpeningTag(On side) {
        if (side == On.LEFT) {
            openTag = openTag.concat(" left");
        } else {
            openTag = openTag.concat(" right");
        }
    }

    public Note(On side) {
        setOpeningTag(side);
    }

    public enum On {
        LEFT, RIGHT
    }

    public Note addTable(ArrayList<String[]> data) {
        Table table = new Table(data);
        elements.add(table);
        return this;
    }

    public Note addTableWithHeader(ArrayList<String[]> data, String[] headers) {
        Table table = new Table(data);
        table.addHeaders(headers);
        elements.add(table);
        return this;
    }

    public String toString() {
        StringBuilder render = new StringBuilder();
        //append start tag
        render.append(openTag).append("\n");

        for (Object element: elements) {
            render.append(element.toString()).append("\n");
        }

        //append end tag
        render.append(closeTag).append("\n");
        return render.toString();
    }

}
