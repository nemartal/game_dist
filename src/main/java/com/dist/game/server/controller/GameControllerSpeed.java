package com.dist.game.server.controller;

import com.dist.game.server.model.Player;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.Answer;
import com.dist.game.share.model.GameType;
import com.dist.game.share.model.Question;
import com.dist.game.share.model.Stats;

public class GameControllerSpeed extends GameController {

    public GameControllerSpeed(GameType type) {
        super(type);
    }

    public synchronized void join(Player player) throws GameMaxUsersException, GameUserAlreadyJoinedException {
        super.join(player);
        this.play(player);
    }

    private void play(Player player) {
        for (int i = 0; i < this.questions.size(); i++) {
            Question question = this.questions.get(i);
            player.sendQuestion(question);
            Answer answer = player.awaitAnswer();

            Stats stats = this.stats.get(player.getId());
            boolean isRight = false;
            for (Answer ans : question.getAnswers()) {
                if (ans.getId().equals(answer.getId()) && ans.isRight()) {
                    isRight = true;
                }
            }

            if (isRight) {
                stats.addRight();
            } else {
                stats.addWrong();
            }
        }
        // Comprobar si han terminado todos
        // Enviar estadisticas
    }
}
