package com.dist.game.server.controller;

import com.dist.game.share.exception.GameNotFoundException;
import com.dist.game.share.model.GameType;

import java.util.HashMap;

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

    public GameController createGame(GameType gameType) {
        //TODO: Create game controller with type
        GameController gc = new GameController();
        this.games.put(gc.getId(), gc);
        return gc;
    }

}
