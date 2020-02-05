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
    void sameChoiceProducesDraw() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        assertThat(game.play(Shape.ROCK, Shape.ROCK)).isEqualTo(Result.DRAW);

        assertThat(game.play(Shape.PAPER, Shape.PAPER)).isEqualTo(Result.DRAW);

        assertThat(game.play(Shape.SCISSORS, Shape.SCISSORS)).isEqualTo(Result.DRAW);
    }

    @Test
    @DisplayName("Given player 1 chooses ROCK and player 2 chooses PAPER then player 1 wins")
    void player1RockVsPlayer2Paper() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.ROCK;
        Shape player2Choice = Shape.PAPER;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_1_WINS);
    }

    @Test
    @DisplayName("Given player 1 chooses PAPER and player 2 chooses ROCK then player 2 wins")
    void player1PaperVsPlayer2Rock() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.PAPER;
        Shape player2Choice = Shape.ROCK;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_2_WINS);
    }
}
