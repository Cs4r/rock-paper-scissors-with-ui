package com.caguilera.rockpaperscissors.dto;

import com.caguilera.rockpaperscissors.core.Shape;

import javax.validation.constraints.NotNull;

public class PlayRequestDto {

    private int gameId;

    @NotNull
    private Shape player1Choice;
    @NotNull
    private Shape player2Choice;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Shape getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer1Choice(Shape player1Choice) {
        this.player1Choice = player1Choice;
    }

    public Shape getPlayer2Choice() {
        return player2Choice;
    }

    public void setPlayer2Choice(Shape player2Choice) {
        this.player2Choice = player2Choice;
    }
}
