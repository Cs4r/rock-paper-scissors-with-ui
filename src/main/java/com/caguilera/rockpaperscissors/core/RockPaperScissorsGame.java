package com.caguilera.rockpaperscissors.core;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Rock, Paper, Scissors game logic
 */
@Component
public class RockPaperScissorsGame {

    public Result play(Shape player1Choice, Shape player2Choice) {
        Objects.requireNonNull(player1Choice, "player1Choice must be non-null");
        Objects.requireNonNull(player2Choice, "player2Choice must be non-null");

        if (player1Choice == player2Choice) {
            return Result.DRAW;
        }

        if (player1Choice == Shape.PAPER && player2Choice == Shape.ROCK) {
            return Result.PLAYER_1_WINS;
        }

        if (player1Choice == Shape.SCISSORS && player2Choice == Shape.PAPER) {
            return Result.PLAYER_1_WINS;
        }

        if (player1Choice == Shape.ROCK && player2Choice == Shape.SCISSORS) {
            return Result.PLAYER_1_WINS;
        }


        return Result.PLAYER_2_WINS;
    }
}
