package com.github.qbek.log2uml.elements.note;

import com.github.qbek.log2uml.elements.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 09/10/16.
 */
public class Note implements Element {

    private static final String OPEN_TAG = "note";
    private static final String CLOSE_TAG = "end note";
    private NotePosition position;

    private List<Object> elements = new ArrayList();


    public Note(String text, NotePosition position) {
        this.position = position;
        elements.add(text);
    }


    @Override
    public String render () {
        StringBuilder render = new StringBuilder(OPEN_TAG);
        //append start tag
        render.append(" ").append(position.render()).append("\n");

        for (Object element: elements) {
            render.append(element.toString()).append("\n");
        }

        //append end tag
        render.append(CLOSE_TAG).append("\n");
        return render.toString();
    }



}
