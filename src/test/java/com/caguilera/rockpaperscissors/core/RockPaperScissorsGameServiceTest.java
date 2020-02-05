package com.caguilera.rockpaperscissors.core;

import com.caguilera.rockpaperscissors.dto.GameResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RockPaperScissorsGameServiceTest {

    @Test
    @DisplayName("playRound tracks rounds, victories and draws")
    void playRound() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();
        GameStatistics statistics = new GameStatistics();

        RockPaperScissorsGameService service = new RockPaperScissorsGameService(game, statistics);

        int gameId = 1;

        service.playRound(gameId, Shape.SCISSORS, Shape.PAPER);
        GameResultDto gameResultDto = service.playRound(gameId, Shape.ROCK, Shape.SCISSORS);

        assertThat(gameResultDto.getGameId()).isEqualTo(gameId);
        assertThat(gameResultDto.getRounds()).isEqualTo(2);
        assertThat(gameResultDto.getTotalRounds()).isEqualTo(2);
        assertThat(gameResultDto.getPlayer1Wins()).isEqualTo(2);
        assertThat(gameResultDto.getPlayer2Wins()).isEqualTo(0);
        assertThat(gameResultDto.getDraws()).isEqualTo(0);
        assertThat(gameResultDto.getLastResult()).isEqualTo(Result.PLAYER_1_WINS);

        gameId = 2;

        service.playRound(gameId, Shape.PAPER, Shape.PAPER);
        service.playRound(gameId, Shape.ROCK, Shape.ROCK);
        service.playRound(gameId, Shape.ROCK, Shape.SCISSORS);

        gameResultDto = service.playRound(gameId, Shape.SCISSORS, Shape.SCISSORS);

        assertThat(gameResultDto.getGameId()).isEqualTo(gameId);
        assertThat(gameResultDto.getRounds()).isEqualTo(4);
        assertThat(gameResultDto.getTotalRounds()).isEqualTo(6);
        assertThat(gameResultDto.getPlayer1Wins()).isEqualTo(3);
        assertThat(gameResultDto.getPlayer2Wins()).isEqualTo(0);
        assertThat(gameResultDto.getDraws()).isEqualTo(3);
        assertThat(gameResultDto.getLastResult()).isEqualTo(Result.DRAW);

        gameId = 3;

        service.playRound(gameId, Shape.ROCK, Shape.PAPER);
        service.playRound(gameId, Shape.PAPER, Shape.SCISSORS);
        service.playRound(gameId, Shape.ROCK, Shape.PAPER);
        gameResultDto = service.playRound(gameId, Shape.PAPER, Shape.SCISSORS);


        assertThat(gameResultDto.getGameId()).isEqualTo(gameId);
        assertThat(gameResultDto.getRounds()).isEqualTo(4);
        assertThat(gameResultDto.getTotalRounds()).isEqualTo(10);
        assertThat(gameResultDto.getPlayer1Wins()).isEqualTo(3);
        assertThat(gameResultDto.getPlayer2Wins()).isEqualTo(4);
        assertThat(gameResultDto.getDraws()).isEqualTo(3);
        assertThat(gameResultDto.getLastResult()).isEqualTo(Result.PLAYER_2_WINS);
    }
}