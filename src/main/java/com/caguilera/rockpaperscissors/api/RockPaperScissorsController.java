package com.caguilera.rockpaperscissors.api;

import com.caguilera.rockpaperscissors.core.RockPaperScissorsGameService;
import com.caguilera.rockpaperscissors.core.Shape;
import com.caguilera.rockpaperscissors.dto.GameResultDto;
import com.caguilera.rockpaperscissors.dto.StatisticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RockPaperScissorsController {

    private final RockPaperScissorsGameService rockPaperScissorsGameService;

    @Autowired
    public RockPaperScissorsController(RockPaperScissorsGameService rockPaperScissorsGameService) {
        this.rockPaperScissorsGameService = rockPaperScissorsGameService;
    }

    @GetMapping
    public ResponseEntity<?> statistics() {
        StatisticsDto statistics = rockPaperScissorsGameService.getStatistics();
        return ResponseEntity.ok(statistics);
    }

    @PostMapping(value = "/play", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> play(@RequestBody @Validated PlayRequestDto playRequest) {

        int gameId = playRequest.getGameId();
        Shape player1Choice = playRequest.getPlayer1Choice();
        Shape player2Choice = playRequest.getPlayer2Choice();

        GameResultDto result = rockPaperScissorsGameService.playRound(gameId, player1Choice, player2Choice);

        return ResponseEntity.ok(result);
    }
}
