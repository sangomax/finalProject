package com.example.handlers;

import com.example.bean.Category;
import com.example.bean.Question;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaXParser {
    static final String QUESTION = "question";
    static final String ID = "id";
    static final String QUESTION_DESC = "questionDesc";
    static final String ANSWER = "answer";
    static final String CLUE = "clue";
    static final String CATEGORY = "category";
    static final String NAME_CATEGORY = "nameCategory";
    static final String CODE_CATEGORY = "codeCategory";
    static final String COLOR_CATEGORY = "colorCategory";
    static final String TYPE = "type";


    @SuppressWarnings({"unchecked", "null"})
    public List<Question> readConfig(String questionsFile) {
        List<Question> questions = new ArrayList<>();
        try {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = new FileInputStream(questionsFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            Question question = null;

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    // If we have an item element, we create a new item
                    String elementName = startElement.getName().getLocalPart();
                    switch (elementName) {
                        case QUESTION:
                            question = new Question();
                            // We read the attributes from this tag and add the date
                            // attribute to our object
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()) {
                                Attribute attribute = attributes.next();
                                if (attribute.getName().toString().equals(ID)) {
                                    question.setIdQuestion(Integer.valueOf(attribute.getValue()));
                                }
                            }
                            break;
                        case QUESTION_DESC:
                            event = eventReader.nextEvent();
                            question.setQuestion(event.asCharacters().getData());
                            break;
                        case ANSWER:
                            event = eventReader.nextEvent();
                            question.setAnswer(event.asCharacters().getData());
                            break;
                        case CLUE:
                            event = eventReader.nextEvent();
                            question.setClue(event.asCharacters().getData());
                            break;
                        case CATEGORY:
                            event = eventReader.nextEvent();
                            question.setCategory(new Category());
                            question.getCategory().setCategory(Integer.valueOf(event.asCharacters().getData()));
                            break;
                        case TYPE:
                            event = eventReader.nextEvent();
                            question.setType(Integer.valueOf(event.asCharacters().getData()));
                            break;
                    }
                }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(QUESTION)) {
                        questions.add(question);
                    }
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
