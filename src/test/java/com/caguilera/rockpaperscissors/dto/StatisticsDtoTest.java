package com.caguilera.rockpaperscissors.dto;

import com.caguilera.rockpaperscissors.core.GameStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class StatisticsDtoTest {

    @Test
    @DisplayName("creates a well formed StatisticsDto")
    void from() {

        GameStatistics statistics = Mockito.mock(GameStatistics.class);

        int totalRounds = 10;
        int player1Wins = 4;
        int player2Wins = 5;
        int draws = 1;

        when(statistics.getTotalRounds()).thenReturn(totalRounds);
        when(statistics.getPlayer1Wins()).thenReturn(player1Wins);
        when(statistics.getPlayer2Wins()).thenReturn(player2Wins);
        when(statistics.getDraws()).thenReturn(draws);

        StatisticsDto statisticsDto = StatisticsDto.from(statistics);

        assertThat(statisticsDto.getTotalRounds()).isEqualTo(totalRounds);
        assertThat(statisticsDto.getPlayer1Wins()).isEqualTo(player1Wins);
        assertThat(statisticsDto.getPlayer2Wins()).isEqualTo(player2Wins);
        assertThat(statisticsDto.getDraws()).isEqualTo(draws);
    }

}