package com.github.qbek.log2uml.elements.message;

import com.github.qbek.log2uml.elements.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jakub Szewczyk on 26/02/2017.
 */
public class MessageGroup implements Element {
    private final String name;
    private final MessageGroupType type;

    private List<Element> elements = new ArrayList<>();

    MessageGroup (String name, MessageGroupType type) {
        this.type = type;
        this.name = name;
    }

    public MessageGroup add (Element... elements) {
        Collections.addAll(this.elements, elements);
        return this;
    }


    @Override
    public String render () {
        StringBuilder render = new StringBuilder();
        render = addMessageGroupHeader(render);
        render = addGroupElements(render);
        render = addMessageGroupFooter(render);
        return render.toString();
    }

    private StringBuilder addMessageGroupFooter (StringBuilder render) {
        if (type == MessageGroupType.ELSE) {
            return render;
        }
        return render.append("end\n");
    }

    private StringBuilder addGroupElements (StringBuilder render) {
        for(Element element : elements) {
            render.append(element.render());
        }
        return render;
    }

    private StringBuilder addMessageGroupHeader (StringBuilder render) {
        render.append(String.format("%s %s\n", type.render(), name));
        return render;
    }
}
