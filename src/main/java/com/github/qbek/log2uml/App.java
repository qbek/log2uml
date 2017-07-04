package com.github.qbek.log2uml;

import com.github.qbek.log2uml.diagram.SequenceDiagram;
import com.github.qbek.log2uml.elements.message.*;
import com.github.qbek.log2uml.elements.note.DefineNote;
import com.github.qbek.log2uml.elements.note.NotePosition;
import com.github.qbek.log2uml.participants.DefineParticipant;
import com.github.qbek.log2uml.participants.ParticipantType;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main (String[] args) throws IOException {

        awesome_diagram_intro("awesome_diagram");
	    declaring_participants("declaring_participants");
        message_basics("message_basics");
	    message_group("message_group");
        message_group_types("message_group_types");
        message_notes("message_notes");
    }

    private static void awesome_diagram_intro (String filename) {
        SequenceDiagram example = SequenceDiagram.title("Awesome diagram");

        example.add(
                DefineMessage
                        .from("John")
                        .to("Diagram")
                        .text("You are so awesome!")
                        .type(MessageType.REQUEST),

                DefineMessage
                        .from("Diagram")
                        .to("John")
                        .text("I know")
                        .type(MessageType.RESPONSE)
        );

        saveDiagram(filename, example);
    }

    private static void declaring_participants (String filename) {

        SequenceDiagram example = SequenceDiagram.title("Declaring participants");

        example.declare(
                DefineParticipant
                        .name("actor")
                        .type(ParticipantType.ACTOR),

                DefineParticipant
                        .name("boundary")
                        .type(ParticipantType.BOUNDARY),

                DefineParticipant
                        .name("control")
                        .type(ParticipantType.CONTROL),

                DefineParticipant
                        .name("database")
                        .type(ParticipantType.DATABASE),

                DefineParticipant
                        .name("entity")
                        .type(ParticipantType.ENTITY),

                DefineParticipant
                        .name("participant")
                        .type(ParticipantType.PARTICIPANT)
        );

        example.add(
                DefineMessage
                        .from("actor")
                        .to("boundary")
                        .text("Hi!")
                        .type(MessageType.REQUEST)
        );

        saveDiagram(filename, example);
    }

    private static void message_basics (String filename) {
        SequenceDiagram messages = SequenceDiagram.title("Messages");

        messages.add(
                DefineMessage
                        .from("Mighty Requestor")
                        .to("Random Bob")
                        .text("I'm requesting hi!")
                        .type(MessageType.REQUEST),

                DefineMessage
                        .from("Random Bob")
                        .to("Mighty Requestor")
                        .text("I'm responding with hi!")
                        .type(MessageType.RESPONSE)
        );

        saveDiagram(filename, messages);
    }

    private static void message_group (String filename) {
        SequenceDiagram group_example = SequenceDiagram.title("Message group");

        group_example.add(
                DefineMessage
                        .from("Bob")
                        .to("Alice")
                        .text("Hi!")
                        .type(MessageType.REQUEST)
        );

        MessageGroup msgGroup = DefineMessageGroup
                                        .name("Small talk")
                                        .type(MessageGroupType.GROUP);

        msgGroup.add(
                DefineMessage
                        .from("Alice")
                        .to("Bob")
                        .text("Hi! How are you?")
                        .type(MessageType.REQUEST),

                DefineMessage
                        .from("Bob")
                        .to("Alice")
                        .text("I'm o'right!")
                        .type(MessageType.RESPONSE)
        );

        group_example.add(msgGroup);

        saveDiagram(filename, group_example);

    }

    private static void message_group_types (String filename) {
        MessageGroup loopBreak = DefineMessageGroup
                                         .name("Repeat 100 times")
                                         .type(MessageGroupType.LOOP);

        loopBreak.add(
                DefineMessage
                        .from("Client")
                        .to("Server")
                        .text("request something fency")
                        .type(MessageType.REQUEST),

                DefineMessageGroup
                        .name("404 response")
                        .type(MessageGroupType.BREAK)
                        .add(
                                DefineMessage
                                        .from("Client")
                                        .to("LogServer")
                                        .text("post logs")
                                        .type(MessageType.REQUEST),
                                DefineMessage
                                        .from("LogServer")
                                        .to("Client")
                                        .text("Roger!")
                                        .type(MessageType.RESPONSE)
                        )
        );

        MessageGroup altElse =
                DefineMessageGroup
                        .name("Server up")
                        .type(MessageGroupType.ALTERNATIVE)
                        .add(DefineMessage
                                     .from("Server")
                                     .to("Client")
                                     .text("Unicorn!!!")
                                     .type(MessageType.RESPONSE),
                                DefineMessageGroup
                                        .name("Server down")
                                        .type(MessageGroupType.ELSE)
                                        .add(DefineMessage
                                                     .from("Server")
                                                     .to("Client")
                                                     .text("404")
                                                     .type(MessageType.RESPONSE)
                                        ),
                                DefineMessageGroup
                                        .name("Server error")
                                        .type(MessageGroupType.ELSE)
                                        .add(DefineMessage
                                                     .from("Server")
                                                     .to("Client")
                                                     .text("500")
                                                     .type(MessageType.RESPONSE)
                                        )
                        );

        SequenceDiagram group_types = SequenceDiagram.title("Message group types");
        group_types.add(loopBreak);
        group_types.add(
                DefineMessage
                        .from("Client")
                        .to("Server")
                        .text("Give me a Unicorn!")
                        .type(MessageType.REQUEST)
        );

        group_types.add(altElse);
        saveDiagram(filename, group_types);
    }


    private static void message_notes (String filename) {
        SequenceDiagram notes = SequenceDiagram.title("Notes");

        notes.add(
                DefineMessage
                        .from("Jeffrey")
                        .to("Dad")
                        .text("Daaaad, can I eat chocolate cake?")
                        .type(MessageType.REQUEST),

                DefineNote
                        .text("Typical morning request")
                        .position(NotePosition.LEFT),

                DefineMessage
                        .from("Dad")
                        .to("Jeffrey")
                        .text("Ask mother")
                        .type(MessageType.RESPONSE),

                DefineNote
                        .text("Defensive move")
                        .position(NotePosition.RIGHT)
        );

        saveDiagram(filename, notes);
    }

    private static void saveDiagram (String filename, SequenceDiagram basic) {
        try {
            basic.save(filename);
            basic.debug(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
