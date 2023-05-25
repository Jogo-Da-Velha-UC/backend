package com.br.uni.edu.jogoDaVelha.requests;

import java.io.Serializable;

public class CreateGameRequest implements Serializable {

    private String playerOne;

    private String playerTwo;

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }
}
