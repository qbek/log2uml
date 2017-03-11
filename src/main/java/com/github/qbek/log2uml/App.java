package com.github.qbek.log2uml;

import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.elements.message.DefineMessage;
import com.github.qbek.log2uml.elements.message.MessageType;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String [ ] args) throws IOException {

	    basicDiagramExample("basic_diagram");

    }

    private static void basicDiagramExample (String filename) {
        SequenceDiagram basic = SequenceDiagram.withTitle("Basic diagram");

        basic.add(DefineMessage.from("Bob").to("Alice").text("Hi!").type(MessageType.REQUEST))
                .add(DefineMessage.from("Alice").to("Bob").text("Oh, hi!").type(MessageType.RESPONSE));
        try {
            basic.save(filename);
            basic.debug(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
