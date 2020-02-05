package com.caguilera.rockpaperscissors.core;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class GameStatistics {

    private Map<Integer, Integer> roundsPerGame = new ConcurrentHashMap<>();

    public void registerRound(int gameId, Result result) {
        roundsPerGame.merge(gameId, 1, Integer::sum);
    }

    public Integer getTotalRounds(int gameId) {
        return Optional.ofNullable(roundsPerGame.get(gameId)).orElse(0);
    }

    public Integer getTotalRounds() {
        return roundsPerGame.values().stream().mapToInt(Integer::intValue).sum();
    }
}
