package com.dist.game.server.controller;

import com.dist.game.server.model.Player;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.GameType;
import com.dist.game.share.model.Question;
import com.dist.game.share.model.Stats;
import com.dist.game.share.util.RandomString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GameController {

    protected List<Player> players;
    protected List<Question> questions;
    protected Map<String, Stats> stats;
    protected String id;
    protected GameType type;


    public GameController(GameType type) {
        this.players = new ArrayList<>();
        this.id = (new RandomString(5)).nextString();
        this.type = type;
        this.stats = new ConcurrentHashMap<>();
    }

    public synchronized void join(Player player) throws GameMaxUsersException, GameUserAlreadyJoinedException {
        if (players.size() == 4) {
            throw new GameMaxUsersException();
        }
        if (players.contains(player)) {
            throw new GameUserAlreadyJoinedException();
        }
        players.add(player);
        stats.put(player.getId(), new Stats());
    }

    public abstract void play(Player player);

    public String getId() {
        return id;
    }

    public GameType getType() {
        return type;
    }
}
