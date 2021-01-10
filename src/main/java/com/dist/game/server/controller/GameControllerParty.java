package com.dist.game.server.controller;

import com.dist.game.server.model.Player;
import com.dist.game.share.model.GameType;

import java.util.HashMap;
import java.util.Map;

public class GameControllerParty extends GameController {

    // Player ID - Position of question in list
    protected Map<String, Integer> control;

    public GameControllerParty(GameType type) {
        super(type);
        this.control = new HashMap<>();
    }

    @Override
    public void play(Player player) {

    }

}
