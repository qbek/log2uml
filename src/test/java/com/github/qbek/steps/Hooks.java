package com.github.qbek.steps;

import com.github.qbek.diagram.SequenceDiagram;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jakub on 02/12/2016.
 */
public class Hooks {

//    public void after() throws IOException {
    public void no() throws IOException {
        SequenceDiagram diagram = SequenceDiagram.getInstance();
        diagram.save(new FileOutputStream(diagram.getTitle() + ".png"));
    }
}
