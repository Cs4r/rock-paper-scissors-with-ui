package com.caguilera.rockpaperscissors.api;

import com.caguilera.rockpaperscissors.service.RockPaperScissorsGameService;
import com.caguilera.rockpaperscissors.dto.GameResultDto;
import com.caguilera.rockpaperscissors.dto.PlayRequestDto;
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

    @GetMapping(value = "/statistics")
    public ResponseEntity<?> getStatistics() {
        StatisticsDto statistics = rockPaperScissorsGameService.getStatistics();
        return ResponseEntity.ok(statistics);
    }

    @PostMapping(value = "/play", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> play(@RequestBody @Validated PlayRequestDto playRequest) {

        GameResultDto result = rockPaperScissorsGameService.playRound(playRequest);

        return ResponseEntity.ok(result);
    }
}
