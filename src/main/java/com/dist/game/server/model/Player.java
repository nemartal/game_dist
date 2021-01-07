package com.dist.game.server.model;

import com.dist.game.share.model.Question;
import com.dist.game.share.model.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Player extends User{
    private ObjectOutputStream oos;
    private ObjectInputStream ios;

    public Player(String nickname, ObjectOutputStream oos, ObjectInputStream ios) {
        super(nickname);
        this.oos = oos;
        this.ios = ios;
    }

    public void sendQuestion(Question question){

    }
}
