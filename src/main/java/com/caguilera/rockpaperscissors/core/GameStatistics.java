package com.caguilera.rockpaperscissors.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameStatistics {

    Map<Integer, Integer> roundsPerGame = new ConcurrentHashMap<>();

    public void registerRound(int gameId, Result result) {
        roundsPerGame.merge(gameId, 1, Integer::sum);
    }

    public Integer getTotalRounds(int gameId) {
        return roundsPerGame.get(gameId);
    }

    public Integer getTotalRounds() {
        return roundsPerGame.values().stream().mapToInt(Integer::intValue).sum();
    }
}
