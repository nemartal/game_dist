package com.dist.game.server.controller;

import com.dist.game.server.model.Player;
import com.dist.game.server.util.RandomQuestions;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.Answer;
import com.dist.game.share.model.GameType;
import com.dist.game.share.model.Question;
import com.dist.game.share.model.Stats;

import java.io.IOException;
import java.util.Map;


public class GameControllerSpeed extends GameController {

    public GameControllerSpeed(GameType type) {
        super(type);
        this.questions = RandomQuestions.load(20);
    }

    public synchronized void join(Player player) throws GameMaxUsersException, GameUserAlreadyJoinedException {
        super.join(player);
        this.play(player);
    }

    private void play(Player player) {

        for (Question question : this.questions) {
            try {
                System.out.println("Enviar pregunta");
                player.sendQuestion(question);
                System.out.println("Esperar respuesta");
                Answer answer = player.awaitAnswer();
                System.out.println("Comprobar respuesta");

                Stats stats = this.stats.get(player.getId());
                boolean isRight = false;
                for (Answer ans : question.getAnswers()) {
                    if (ans.getId().equals(answer.getId()) && ans.isRight()) {
                        isRight = true;
                        break;
                    }
                }

                if (isRight) {
                    stats.addRight();
                } else {
                    stats.addWrong();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            this.waitToFinish();
            player.sendStats(this.stats);
        } catch (Exception ignored) {
        }


    }

    private void waitToFinish() throws InterruptedException {
        int max = 60;
        int n = 0;
        boolean end = false;
        while (n <= max && !end) {
            boolean allFinish = true;
            n++;
            Thread.sleep(1000);
            for (Map.Entry<String, Stats> stats : this.stats.entrySet()) {
                if (stats.getValue().getRight() + stats.getValue().getWrong() < 20) {
                    allFinish = false;
                    break;
                }
            }
            if (allFinish) end = true;
        }

    }
}
