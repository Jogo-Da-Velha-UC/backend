package com.br.uni.edu.jogoDaVelha.dtos;

import java.util.HashMap;
import java.util.Map;

public class MoveDTO {

    private String player;
    private Map<String, String> values = new HashMap<>();

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }
}
