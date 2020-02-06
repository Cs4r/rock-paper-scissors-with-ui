package com.caguilera.rockpaperscissors.core;

import com.caguilera.rockpaperscissors.dto.PlayRequestDto;
import com.caguilera.rockpaperscissors.dto.GameResultDto;
import com.caguilera.rockpaperscissors.dto.StatisticsDto;
import com.caguilera.rockpaperscissors.service.RockPaperScissorsGameService;
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

        service.playRound(playRequest(gameId, Shape.SCISSORS, Shape.PAPER));
        GameResultDto gameResultDto = service.playRound(playRequest(gameId, Shape.ROCK, Shape.SCISSORS));

        assertThat(gameResultDto.getGameId()).isEqualTo(gameId);
        assertThat(gameResultDto.getRounds()).isEqualTo(2);
        assertThat(gameResultDto.getTotalRounds()).isEqualTo(2);
        assertThat(gameResultDto.getPlayer1Wins()).isEqualTo(2);
        assertThat(gameResultDto.getPlayer2Wins()).isEqualTo(0);
        assertThat(gameResultDto.getDraws()).isEqualTo(0);
        assertThat(gameResultDto.getLastResult()).isEqualTo(Result.PLAYER_1_WINS);

        gameId = 2;

        service.playRound(playRequest(gameId, Shape.PAPER, Shape.PAPER));
        service.playRound(playRequest(gameId, Shape.ROCK, Shape.ROCK));
        service.playRound(playRequest(gameId, Shape.ROCK, Shape.SCISSORS));

        gameResultDto = service.playRound(playRequest(gameId, Shape.SCISSORS, Shape.SCISSORS));

        assertThat(gameResultDto.getGameId()).isEqualTo(gameId);
        assertThat(gameResultDto.getRounds()).isEqualTo(4);
        assertThat(gameResultDto.getTotalRounds()).isEqualTo(6);
        assertThat(gameResultDto.getPlayer1Wins()).isEqualTo(3);
        assertThat(gameResultDto.getPlayer2Wins()).isEqualTo(0);
        assertThat(gameResultDto.getDraws()).isEqualTo(3);
        assertThat(gameResultDto.getLastResult()).isEqualTo(Result.DRAW);

        gameId = 3;

        service.playRound(playRequest(gameId, Shape.ROCK, Shape.PAPER));
        service.playRound(playRequest(gameId, Shape.PAPER, Shape.SCISSORS));
        service.playRound(playRequest(gameId, Shape.ROCK, Shape.PAPER));
        gameResultDto = service.playRound(playRequest(gameId, Shape.PAPER, Shape.SCISSORS));


        assertThat(gameResultDto.getGameId()).isEqualTo(gameId);
        assertThat(gameResultDto.getRounds()).isEqualTo(4);
        assertThat(gameResultDto.getTotalRounds()).isEqualTo(10);
        assertThat(gameResultDto.getPlayer1Wins()).isEqualTo(3);
        assertThat(gameResultDto.getPlayer2Wins()).isEqualTo(4);
        assertThat(gameResultDto.getDraws()).isEqualTo(3);
        assertThat(gameResultDto.getLastResult()).isEqualTo(Result.PLAYER_2_WINS);
    }

    @Test
    @DisplayName("getStatistics returns dto with stats")
    void getStatistics() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();
        GameStatistics statistics = new GameStatistics();

        RockPaperScissorsGameService service = new RockPaperScissorsGameService(game, statistics);

        int gameId = 1;

        service.playRound(playRequest(gameId, Shape.SCISSORS, Shape.PAPER));
        service.playRound(playRequest(gameId, Shape.ROCK, Shape.SCISSORS));
        service.playRound(playRequest(gameId, Shape.PAPER, Shape.SCISSORS));

        service.playRound(playRequest(gameId, Shape.PAPER, Shape.PAPER));
        service.playRound(playRequest(gameId, Shape.SCISSORS, Shape.SCISSORS));
        service.playRound(playRequest(gameId, Shape.ROCK, Shape.ROCK));

        StatisticsDto statisticsDto = service.getStatistics();

        assertThat(statisticsDto.getTotalRounds()).isEqualTo(6);
        assertThat(statisticsDto.getPlayer1Wins()).isEqualTo(2);
        assertThat(statisticsDto.getPlayer2Wins()).isEqualTo(1);
        assertThat(statisticsDto.getDraws()).isEqualTo(3);
    }


    private static PlayRequestDto playRequest(int gameId, Shape player1Choice, Shape player2Choice) {
        PlayRequestDto playRequestDto = new PlayRequestDto();

        playRequestDto.setGameId(gameId);
        playRequestDto.setPlayer1Choice(player1Choice);
        playRequestDto.setPlayer2Choice(player2Choice);

        return playRequestDto;
    }
}