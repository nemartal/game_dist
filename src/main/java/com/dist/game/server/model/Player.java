package com.dist.game.server.model;

import com.dist.game.share.model.Answer;
import com.dist.game.share.model.Question;
import com.dist.game.share.model.Stats;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Player {
    private final String id;
    private final String nickname;
    private ObjectOutputStream oos;
    private ObjectInputStream ios;

    public Player(String nickname, ObjectOutputStream oos, ObjectInputStream ios) {
        this.oos = oos;
        this.ios = ios;
        this.id = UUID.randomUUID().toString();
        this.nickname = nickname;
    }

    public void sendQuestion(Question question) {

    }

    public void sendStats(Map<String, Stats> stats){

    }

    public Answer awaitAnswer() {
        return null;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
