package com.dist.game.server.controller;

import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.User;

import java.util.List;

public class GameController {

    private List<User> users;

    public GameController() {

    }

    public synchronized void join(User user) throws GameMaxUsersException, GameUserAlreadyJoinedException {
        if(users.size() == 4){
            throw new GameMaxUsersException();
        }
        if(users.contains(user)){
            throw new GameUserAlreadyJoinedException();
        }
        users.add(user);
    }
}
