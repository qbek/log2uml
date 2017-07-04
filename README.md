# log2uml

Simple java wrapper for plantuml, allow to expressively create UML diagrams with java.

<!-- MarkdownTOC bracket="round" autoanchor="true" autolink="true"-->

- [Getting started](#getting-started)
    - [Run examples](#run-examples)
    - [JAR file](#jar-file)
    - [Maven dependency](#maven-dependency)
    - [Basic diagram](#basic-diagram)
- [Sequence Diagram elements](#sequence-diagram-elements)
    - [Participants](#participants)
    - [Messages](#messages)
    - [Message groups](#message-groups)
    - [Notes](#notes)

<!-- /MarkdownTOC -->


<a name="getting-started"></a>
## Getting started

<a name="run-examples"></a>
### Run examples

_log2uml_ repository includes samples of all its features.

Compile it

```bash
mvn clean compile
```
and run it:

```bash
mvn exec:java
```

<a name="jar-file"></a>
### JAR file

To add _log2uml_ as JAR to your project class path, first you have to generate it using following command:

```bahs
mvn clean package
```

<a name="maven-dependency"></a>
### Maven dependency

You need to add following maven dependency to your pom.xml file:

```xml
<dependency>
    <groupId>com.github.qbek</groupId>
    <artifactId>log2uml</artifactId>
    <version>0.2</version>
</dependency>
```

<a name="basic-diagram"></a>
### Basic diagram

To create sequence diagram, just provide great title...

```java

SequenceDiagram awesomeDiagram = SequenceDiagram.title("Awesome diagram");

```

...and you are ready to add elements to it...


```java
awesomeDiagram.add(
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
```

...and finally you can save it to PNG file.


```java
awesomeDiagram.save("awesome_diagram");
```

And this is result:

![Awesome diagram example](https://github.com/qbek/log2uml/blob/master/doc/awesome_diagram.png "Awesome diagram")

https://github.com/qbek/log2uml/blob/docs/doc/awesome_diagram.png?raw=true
<a name="sequence-diagram-elements"></a>
## Sequence Diagram elements


<a name="participants"></a>
### Participants

You can declare many types of participants. They will be rendered in declaration order from left to right

```java
SequenceDiagram example = SequenceDiagram.title("Declaring participants");

example.declare(
    DefineParticipant.name("actor").type(ParticipantType.ACTOR),
    DefineParticipant.name("boundary").type(ParticipantType.BOUNDARY),
    DefineParticipant.name("control").type(ParticipantType.CONTROL),
    DefineParticipant.name("database").type(ParticipantType.DATABASE),
    DefineParticipant.name("entity").type(ParticipantType.ENTITY),
    DefineParticipant.name("participant").type(ParticipantType.PARTICIPANT)
);

example.add(
  DefineMessage.from("actor").to("boundary").text("Hi!").type(MessageType.REQUEST)
);

```

As result you will get:

![Declaring participants example](https://github.com/qbek/log2uml/blob/master/doc/declaring_participants.png "Declaring participants")


<a name="messages"></a>
### Messages

The most important element of each sequence diagram is a massage. Lets add some!

```java
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
```

Result:

![Message example](https://github.com/qbek/log2uml/blob/master/doc/message_basics.png "Message basics diagram")

<a name="message-groups"></a>
### Message groups

You can also define message group:

```java
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
```

![Generic group example](https://github.com/qbek/log2uml/blob/master/doc/message_group.png "Message group diagram")

There are more types of groups ready to use:
+ OPT
+ LOOP
+ PARALLEL
+ BREAK
+ CRITICAL
+ ALTERNATIVE, ELSE

Simple example:

```java
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
```

![Message group types example](https://github.com/qbek/log2uml/blob/master/doc/message_group_types.png "Message group types diagram")

<a name="notes"></a>
### Notes

You can add some note to


```java
exampleDiagram.addNote(
    DefineNote.text("Sample note").position(LEFT).build()
);

exampleDiagram.addNote(
    DefineNote.text("Another note").position(RIGHT).build()
);
```

