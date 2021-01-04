package com.dist.game.server.controller;

import com.dist.game.share.exception.GameNotFoundException;
import com.dist.game.server.model.Game;
import com.dist.game.server.model.GameType;

import java.util.HashMap;
import java.util.UUID;

public class MatchMakingController {

    private final HashMap<String, GameController> games;
    private static MatchMakingController instance;

    private MatchMakingController() {
        this.games = new HashMap<>();
    }

    public static MatchMakingController getInstance() {
        if (instance == null) {
            instance = new MatchMakingController();
        }
        return instance;
    }

    public GameController getGame(String id) throws GameNotFoundException {
        if (!this.games.containsKey(id)) {
            throw new GameNotFoundException();
        }
        return this.games.get(id);
    }

    public Game createGame(GameType type) {
        String id = UUID.randomUUID().toString();
        //TODO: Create by type
        return null;
    }
}
