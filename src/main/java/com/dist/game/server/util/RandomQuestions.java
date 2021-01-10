package com.dist.game.server.util;

import com.dist.game.share.model.Answer;
import com.dist.game.share.model.Question;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomQuestions {
    public static List<Question> load(int n) {
        List<Question> questions = new ArrayList<>();
        try {
            InputStream in = RandomQuestions.class.getClassLoader().getResourceAsStream("questions.xml");

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;

            docBuilder = docBuilderFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(in);

            NodeList nList = doc.getElementsByTagName("question");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element question = (Element) nNode;

                    Question q = new Question(
                            question.getElementsByTagName("id").item(0).getTextContent(),
                            question.getElementsByTagName("text").item(0).getTextContent()
                    );


                    NodeList nAnswers = question.getElementsByTagName("answer");
                    for (int i = 0; i < nAnswers.getLength(); i++) {
                        Node nodeAnswer = nAnswers.item(i);
                        if (nodeAnswer.getNodeType() == Node.ELEMENT_NODE) {
                            Element answer = (Element) nNode;
                            q.addAnswer(new Answer(
                                    answer.getElementsByTagName("id").item(0).getTextContent(),
                                    answer.getElementsByTagName("text").item(0).getTextContent(),
                                    answer.getElementsByTagName("correct").item(0).getTextContent().equals("1")
                            ));
                        }
                    }
                    questions.add(q);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(questions);
        return questions.subList(0, n);
    }
}
