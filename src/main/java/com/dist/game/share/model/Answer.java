package com.dist.game.share.model;

import java.io.Serializable;
import java.util.Objects;

public class Answer implements Serializable {

    private final String id;

    private final String text;

    private transient final boolean rightAnswer;

    public Answer(String id, String text, boolean rightAnswer) {
        this.id = id;
        this.text = text;
        this.rightAnswer = rightAnswer;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    /**
     * Return if the answer is right or wrong
     *
     * @return if the answer is right or wrong
     */
    public boolean isRight() {
        return this.rightAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return rightAnswer == answer.rightAnswer &&
                Objects.equals(id, answer.id) &&
                Objects.equals(text, answer.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, rightAnswer);
    }
}
