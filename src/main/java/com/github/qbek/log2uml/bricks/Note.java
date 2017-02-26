package com.github.qbek.log2uml.bricks;

import com.github.qbek.log2uml.bricks.glues.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 09/10/16.
 */
public class Note {

    private static String OPENING_TAG = "note";
    private static String CLOSING_TAG = "end note";
    private List<Object> elements = new ArrayList();

    public Note(String text, On side) {
        elements.add(text);
        setOpeningTag(side);
    }

    private void setOpeningTag(On side) {
        if (side == On.LEFT) {
            OPENING_TAG = OPENING_TAG.concat(" left");
        } else {
            OPENING_TAG = OPENING_TAG.concat(" right");
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
        render.append(OPENING_TAG).append("\n");

        for (Object element: elements) {
            render.append(element.toString()).append("\n");
        }

        //append end tag
        render.append(CLOSING_TAG).append("\n");
        return render.toString();
    }

}
