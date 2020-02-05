package com.caguilera.rockpaperscissors;

public class RockPaperScissorsGame {

    public Result play(Shape player1Choice, Shape player2Choice) {
        if (player1Choice == player2Choice) {
            return Result.DRAW;
        }
        return Result.PLAYER_1_WINS;
    }
}
