package com.caguilera.rockpaperscissors.dto;

import com.caguilera.rockpaperscissors.core.GameStatistics;

public class GameResultDto {

    private final int gameId;
    private final int rounds;
    private final int totalRounds;
    private final int player1Wins;
    private final int player2Wins;
    private final int draws;

    private GameResultDto(int gameId, int rounds, int totalRounds, int player1Wins, int player2Wins, int draws) {
        this.gameId = gameId;
        this.rounds = rounds;
        this.totalRounds = totalRounds;
        this.player1Wins = player1Wins;
        this.player2Wins = player2Wins;
        this.draws = draws;
    }

    public static GameResultDto from(int gameId, GameStatistics statistics) {
        int rounds = statistics.getTotalRounds(gameId);
        int totalRounds = statistics.getTotalRounds();
        int player1Wins = statistics.getPlayer1Wins();
        int player2Wins = statistics.getPlayer2Wins();
        int draws = statistics.getDraws();

        return new GameResultDto(gameId, rounds, totalRounds, player1Wins, player2Wins, draws);
    }

    public int getGameId() {
        return gameId;
    }

    public int getRounds() {
        return rounds;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public int getDraws() {
        return draws;
    }
}
