package com.dist.game.share.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private String id;
    private String text;

    private ArrayList<Answer> answers;

    public Question(String id, String text) {
        this.id = id;
        this.text = text;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
