package com.caguilera.rockpaperscissors.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStatisticsTest {

    @Test
    @DisplayName("registerRound updates the number of rounds of a given game")
    void registerRoundUpdatesTotalOfRoundsForAGame() {
        GameStatistics gameStatistics = new GameStatistics();

        int gameId = 1010;

        gameStatistics.registerRound(gameId, Result.PLAYER_1_WINS);
        gameStatistics.registerRound(gameId, Result.PLAYER_2_WINS);
        gameStatistics.registerRound(gameId, Result.PLAYER_2_WINS);
        gameStatistics.registerRound(gameId, Result.PLAYER_2_WINS);

        assertThat(gameStatistics.getTotalRounds(gameId)).isEqualTo(4);

        gameId = 2525;

        gameStatistics.registerRound(gameId, Result.PLAYER_2_WINS);

        assertThat(gameStatistics.getTotalRounds(gameId)).isEqualTo(1);
    }

    @Test
    @DisplayName("registerRound updates the global number of rounds")
    void registerRoundUpdatesGlobalNumberOfRounds() {

        GameStatistics gameStatistics = new GameStatistics();

        gameStatistics.registerRound(1, Result.DRAW);
        gameStatistics.registerRound(2, Result.PLAYER_1_WINS);
        gameStatistics.registerRound(3, Result.PLAYER_2_WINS);

        assertThat(gameStatistics.getTotalRounds()).isEqualTo(3);

        gameStatistics.registerRound(5, Result.DRAW);

        assertThat(gameStatistics.getTotalRounds()).isEqualTo(4);
    }

    @Test
    @DisplayName("getTotalRounds for gameId returns 0 if no gameId exists")
    void getTotalRoundsForGameIdWhenGameIdDoesNotExists() {
        GameStatistics gameStatistics = new GameStatistics();

        assertThat(gameStatistics.getTotalRounds(1)).isZero();
    }

    @Test
    @DisplayName("getTotalRounds return 0 if no games")
    void getTotalRoundsWhenNoGames() {
        GameStatistics gameStatistics = new GameStatistics();

        assertThat(gameStatistics.getTotalRounds()).isZero();
    }
}