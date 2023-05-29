package com.br.uni.edu.jogoDaVelha.requests;

import java.io.Serializable;

public class CreateGameRequest implements Serializable {

    private String player;

    private String playerTwo;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
