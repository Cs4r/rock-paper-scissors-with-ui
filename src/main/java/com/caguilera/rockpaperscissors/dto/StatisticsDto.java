package com.caguilera.rockpaperscissors.dto;

import com.caguilera.rockpaperscissors.core.GameStatistics;

public class StatisticsDto {
    private final int totalRounds;
    private final int player1Wins;
    private final int player2Wins;
    private final int draws;

    private StatisticsDto(
            int totalRounds,
            int player1Wins,
            int player2Wins,
            int draws) {
        this.totalRounds = totalRounds;
        this.player1Wins = player1Wins;
        this.player2Wins = player2Wins;
        this.draws = draws;
    }

    public static StatisticsDto from(GameStatistics statistics) {
        int totalRounds = statistics.getTotalRounds();
        int player1Wins = statistics.getPlayer1Wins();
        int player2Wins = statistics.getPlayer2Wins();
        int draws = statistics.getDraws();

        return new StatisticsDto(totalRounds, player1Wins, player2Wins, draws);
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
