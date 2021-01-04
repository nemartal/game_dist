package com.dist.game.server.controller;

import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.server.model.Game;
import com.dist.game.share.model.User;

import java.util.List;

public class GameController {

    private Game game;
    private List<User> users;

    public GameController(Game game) {

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
