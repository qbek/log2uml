# log2uml

## Getting started

### Creating diagram

'''java
SequenceDiagram showCase = SequenceDiagram.title("Awesome diagram");
'''

### Adding elements

'''java
showCase.add(Element elemen)
'''

Element can be:

    + Message
    + MessageGroup
    + Note

### Messages

__Creating__

'''java
showCase.add(
    CreateMessage.from("John").to("Anna").text("hi").type(REQUEST);
    CreateMessage.from("John").toSelf().text("hi").type(REQUEST);
);

showCase.add(
    CreateMessage.from("Anna").to("John").msg("Hello").type(RESPONSE);
);
'''

__Message groups__


'''java
ShowCase.addMessageGroup(
    CreateMessageGroup.type(OWN_GROUP).label("Same label").build()
        .addMessage(...)
        .addMessage(...)
);

### Notes

'''java
showCase.addNote(
    CreateNote.text("Sample note").position(LEFT).build()
);

showCase.addNote(
    CreateNote.text("Another note").position(RIGHT).build()
);
'''

