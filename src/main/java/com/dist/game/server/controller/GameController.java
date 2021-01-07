package com.dist.game.server.controller;

import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.GameType;
import com.dist.game.share.model.User;
import com.dist.game.share.util.RandomString;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<User> users;
    private String id;
    private GameType type;

    public GameController(GameType type) {
        this.users = new ArrayList<>();
        this.id = (new RandomString(5)).nextString();
        this.type = type;
    }

    public synchronized void join(User user) throws GameMaxUsersException, GameUserAlreadyJoinedException {
        if (users.size() == 4) {
            throw new GameMaxUsersException();
        }
        if (users.contains(user)) {
            throw new GameUserAlreadyJoinedException();
        }
        users.add(user);
    }

    public String getId() {
        return id;
    }

    public GameType getType() {
        return type;
    }
}
