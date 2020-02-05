package com.caguilera.rockpaperscissors.core;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GameStatistics {

    private Map<Integer, Integer> roundsPerGame = new ConcurrentHashMap<>();
    private AtomicInteger player1Wins = new AtomicInteger(0);
    private AtomicInteger player2Wins = new AtomicInteger(0);

    public void registerRound(int gameId, Result result) {
        if (result == Result.PLAYER_1_WINS) {
            player1Wins.addAndGet(1);
        } else if (result == Result.PLAYER_2_WINS) {
            player2Wins.addAndGet(1);
        }
        roundsPerGame.merge(gameId, 1, Integer::sum);
    }

    public int getTotalRounds(int gameId) {
        return Optional.ofNullable(roundsPerGame.get(gameId)).orElse(0);
    }

    public int getTotalRounds() {
        return roundsPerGame.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getPlayer1Wins() {
        return player1Wins.get();
    }

    public int getPlayer2Wins() {
        return player2Wins.get();
    }
}
