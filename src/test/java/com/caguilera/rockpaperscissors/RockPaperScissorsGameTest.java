package com.caguilera.rockpaperscissors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorsGameTest {

    @Test
    public void canCreateGame() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
    }

    @Test
    @DisplayName("Given same choice for both players, then game ends up in draw")
    public void sameChoiceProducesDraw() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        assertThat(game.play(Shape.ROCK, Shape.ROCK)).isEqualTo(Result.DRAW);

        assertThat(game.play(Shape.PAPER, Shape.PAPER)).isEqualTo(Result.DRAW);

        assertThat(game.play(Shape.SCISSORS, Shape.SCISSORS)).isEqualTo(Result.DRAW);
    }
}
