package com.caguilera.rockpaperscissors.dto;

import com.caguilera.rockpaperscissors.core.GameStatistics;
import com.caguilera.rockpaperscissors.core.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class GameResultDtoTest {

    @Test
    @DisplayName("creates a well formed GameResultDto")
    void from() {

        GameStatistics statistics = Mockito.mock(GameStatistics.class);

        int gameId = 30;
        int rounds = 1;
        int totalRounds = 10;
        int player1Wins = 4;
        int player2Wins = 5;
        int draws = 1;

        when(statistics.getTotalRounds(gameId)).thenReturn(rounds);
        when(statistics.getTotalRounds()).thenReturn(totalRounds);
        when(statistics.getPlayer1Wins()).thenReturn(player1Wins);
        when(statistics.getPlayer2Wins()).thenReturn(player2Wins);
        when(statistics.getDraws()).thenReturn(draws);

        Result lastResult = Result.DRAW;
        GameResultDto gameResultDto = GameResultDto.from(gameId, lastResult, statistics);

        assertThat(gameResultDto.getGameId()).isEqualTo(gameId);
        assertThat(gameResultDto.getTotalRounds()).isEqualTo(totalRounds);
        assertThat(gameResultDto.getRounds()).isEqualTo(rounds);
        assertThat(gameResultDto.getPlayer1Wins()).isEqualTo(player1Wins);
        assertThat(gameResultDto.getPlayer2Wins()).isEqualTo(player2Wins);
        assertThat(gameResultDto.getDraws()).isEqualTo(draws);
    }
}