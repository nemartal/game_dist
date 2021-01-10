package com.dist.game.server.controller;

import com.dist.game.server.model.Player;
import com.dist.game.server.util.RandomQuestions;
import com.dist.game.share.exception.GameMaxUsersException;
import com.dist.game.share.exception.GameUserAlreadyJoinedException;
import com.dist.game.share.model.Answer;
import com.dist.game.share.model.GameType;
import com.dist.game.share.model.Question;
import com.dist.game.share.model.Stats;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameControllerParty extends GameController {

    // Player ID - Num Question
    protected Map<String, Integer> control;

    public GameControllerParty(GameType type) {
        super(type);
        this.control = new ConcurrentHashMap<>();
        this.questions = RandomQuestions.load(10);
    }

    public synchronized void join(Player player) throws GameMaxUsersException, GameUserAlreadyJoinedException {
        super.join(player);
        this.control.put(player.getId(), 0);
    }

    public void play(Player player) {
        Stats stats = this.stats.get(player.getId());
        try {
            waitAllPlayers();
            stats.setStart(new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Question question : this.questions) {
            try {
                player.sendQuestion(question);
                Answer answer = player.awaitAnswer();
                this.control.put(player.getId(), this.control.get(player.getId() + 1));
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
                waitToNextQuestion(player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stats.setFinish(new Date());
        try {
            this.waitToFinish();
            player.sendStats(this.stats);

            // Map <ID, Nickname>
            Map<String, String> players = new HashMap<>();
            for (Player p : this.players) {
                players.put(p.getId(), p.getNickname());
            }
            player.sendPlayers(players);
        } catch (Exception ignored) {
        }


    }

    private void waitAllPlayers() throws InterruptedException {
        int max = 60;
        int n = 0;
        while (n <= max && this.players.size() < 2) {
            Thread.sleep(1000);
            n++;
        }
    }

    private void waitToNextQuestion(Player player) throws InterruptedException {
        int max = 60;
        int n = 0;
        boolean end = false;
        int num = this.control.get(player.getId());
        while (n <= max && !end) {
            boolean allFinish = true;
            Thread.sleep(1000);
            for (Map.Entry<String, Integer> controls : this.control.entrySet()) {
                if (controls.getValue() != num) {
                    allFinish = false;
                    break;
                }
            }
            if (allFinish) end = true;
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
                if (stats.getValue().getRight() + stats.getValue().getWrong() < 10) {
                    allFinish = false;
                    break;
                }
            }
            if (allFinish) end = true;
        }
    }

}
