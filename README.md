# log2uml

Simple java wrapper for plantuml, allow to expressively create UML diagrams with java.

<!-- MarkdownTOC bracket="round" autoanchor="true" autolink="true"-->

- [Getting started](#getting-started)
    - [Examples](#examples)
    - [Maven](#maven)
    - [Creating diagram](#creating-diagram)
    - [Participants](#participants)
    - [Messages](#messages)
    - [Notes](#notes)

<!-- /MarkdownTOC -->


<a name="getting-started"></a>
## Getting started

<a name="examples"></a>
### Examples



<a name="maven"></a>
### Maven

You need to add following maven dependency to your pom.xml file:

```xml
<dependency>
    <groupId>com.github.qbek</groupId>
    <artifactId>log2uml</artifactId>
    <version>0.2</version>
</dependency>
```


<a name="creating-diagram"></a>
### Creating diagram

To create sequence diagram, just provide great title...

```java

SequenceDiagram awesomeDiagram = SequenceDiagram.title("Awesome diagram");

```

...and you are ready to add elements to it...


```java
awesomeDiagram.add(
    DefineMessage.from("John").to("Diagram").text("You are so awesome!").type(MessageType.REQUEST),
    DefineMessage.from("Diagram").to("John").text("I know").type(MessageType.RESPONSE)
);
```

...and finally you can save it to PNG file.


```java
awesomeDiagram.save("awesome_diagram");
```

And this is result:

![Awesome diagram examzple](https://github.com/qbek/log2uml/blob/master/doc/awesome_diagram.png "Awesome diagram")

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

example.save("declaring_participant");

```

As result you will get:

![Declaring participants examzple](https://github.com/qbek/log2uml/blob/master/doc/declaring_participants.png "Declaring participants")


<a name="messages"></a>
### Messages

The most important element of each sequence diagram is a massage. Lets add one!

```java
SequenceDiagram messages = SequenceDiagram.title("Messages");

messages.add(
    DefineMessage.from("Mighty Requestor").to("Random Bob").text("I'm requesting hi!").type(MessageType.REQUEST),
    DefineMessage.from("Random Bob").to("Mighty Requestor").text("I'm responding with hi!").type(MessageType.RESPONSE)
);

messages.save("message_basics");
```





```java
exampleDiagram.add(
    DefineMessage.from("John").to("Anna").text("hi").type(REQUEST);
    DefineMessage.from("John").toSelf().text("hi").type(REQUEST);
);

exampleDiagram.add(
    DefineMessage.from("Anna").to("John").msg("Hello").type(RESPONSE);
);
```

__Message groups__


```java
exampleDiagram.addMessageGroup(
    DefineMessageGroup.type(OWN_GROUP).label("Same label").build()
        .addMessage(...)
        .addMessage(...)
);
```

<a name="notes"></a>
### Notes

```java
exampleDiagram.addNote(
    DefineNote.text("Sample note").position(LEFT).build()
);

exampleDiagram.addNote(
    DefineNote.text("Another note").position(RIGHT).build()
);
```

