package com.br.uni.edu.jogoDaVelha.dtos;

import com.br.uni.edu.jogoDaVelha.model.Match;

import java.util.HashMap;
import java.util.Map;

public class MoveDTO {

    private Long id;
    private PlayerDto currentPlayer;
    private Map<String, String> values = new HashMap<>();

    public MoveDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerDto getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerDto currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }
}
