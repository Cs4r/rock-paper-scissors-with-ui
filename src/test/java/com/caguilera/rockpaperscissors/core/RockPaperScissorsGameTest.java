package com.caguilera.rockpaperscissors.core;

import com.caguilera.rockpaperscissors.core.Result;
import com.caguilera.rockpaperscissors.core.RockPaperScissorsGame;
import com.caguilera.rockpaperscissors.core.Shape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("Given player 1 chooses ROCK and player 2 chooses PAPER then player 2 wins")
    void player1RockVsPlayer2Paper() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.ROCK;
        Shape player2Choice = Shape.PAPER;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_2_WINS);
    }

    @Test
    @DisplayName("Given player 1 chooses PAPER and player 2 chooses ROCK then player 1 wins")
    void player1PaperVsPlayer2Rock() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.PAPER;
        Shape player2Choice = Shape.ROCK;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_1_WINS);
    }


    @Test
    @DisplayName("Given player 1 chooses PAPER and player 2 chooses SCISSORS then player 2 wins")
    void player1PaperVsPlayer2Scissors() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.PAPER;
        Shape player2Choice = Shape.SCISSORS;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_2_WINS);
    }

    @Test
    @DisplayName("Given player 1 chooses SCISSORS and player 2 chooses PAPER then player 1 wins")
    void player1ScissorsVsPlayer2Paper() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.SCISSORS;
        Shape player2Choice = Shape.PAPER;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_1_WINS);
    }

    @Test
    @DisplayName("Given player 1 chooses ROCK and player 2 chooses SCISSORS then player 1 wins")
    void player1RockVsPlayer2Scissors() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.ROCK;
        Shape player2Choice = Shape.SCISSORS;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_1_WINS);
    }

    @Test
    @DisplayName("Given player 1 chooses SCISSORS and player 2 chooses ROCK then player 2 wins")
    void player1ScissorsVsPlayer2Rock() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        Shape player1Choice = Shape.SCISSORS;
        Shape player2Choice = Shape.ROCK;

        assertThat(game.play(player1Choice, player2Choice)).isEqualTo(Result.PLAYER_2_WINS);
    }

    @Test
    void player1ChoiceCannotBeNull() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        assertThatThrownBy(() -> game.play(null, Shape.ROCK)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void player2ChoiceCannotBeNull() {

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        assertThatThrownBy(() -> game.play(Shape.ROCK, null)).isInstanceOf(NullPointerException.class);
    }
}
