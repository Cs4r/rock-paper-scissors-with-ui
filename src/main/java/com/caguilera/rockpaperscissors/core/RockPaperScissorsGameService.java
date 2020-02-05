package com.caguilera.rockpaperscissors.core;


import com.caguilera.rockpaperscissors.dto.GameResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorsGameService {

    private final RockPaperScissorsGame game;
    private final GameStatistics statistics;

    @Autowired
    public RockPaperScissorsGameService(RockPaperScissorsGame game, GameStatistics statistics) {
        this.game = game;
        this.statistics = statistics;
    }

    public GameResultDto playRound(int gameId, Shape player1Choice, Shape player2Choice) {

        Result result = game.play(player1Choice, player2Choice);

        statistics.registerRound(gameId, result);

        return GameResultDto.from(gameId, statistics);
    }

}
