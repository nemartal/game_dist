package com.dist.game.server.controller;

import com.dist.game.server.exception.GameNotFoundException;
import com.dist.game.server.model.Game;

import java.util.HashMap;

public class GameController {

    private final HashMap<String, Game> games;
    private static GameController game;

    private GameController() {
        this.games = new HashMap<>();
    }

    public static GameController getInstance() {
        if (game == null) {
            game = new GameController();
        }
        return game;
    }

    public Game getGame(String id) throws GameNotFoundException {
        if (!this.games.containsKey(id)) {
            throw new GameNotFoundException();
        }
        return this.games.get(id);
    }
}
