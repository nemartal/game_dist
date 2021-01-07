package com.dist.game.server.controller;

import com.dist.game.server.model.Player;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.Answer;
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
        for(int i = 0; i < this.questions.size(); i++){
            player.sendQuestion(this.questions.get(i));
            Answer answer = player.awaitAnswer();
            // TODO: Check answer and update stats
        }
        // Comprobar si han terminado todos
        // Enviar estadisticas
    }
}
