package com.dist.game.server.controller;

import com.dist.game.server.model.Player;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.GameType;

public class GameControllerSpeed extends GameController {

    public GameControllerSpeed(GameType type) {
        super(type);
    }

    public synchronized void join(Player player) throws GameMaxUsersException, GameUserAlreadyJoinedException {
        super.join(player);
        this.play(player);
    }

    private void play(Player player){
        // 20 veces
            //player.sendQuestion();
            //player.getAnwser();

        // Comprobar si han terminado todos
        // Enviar estadisticas
    }
}
