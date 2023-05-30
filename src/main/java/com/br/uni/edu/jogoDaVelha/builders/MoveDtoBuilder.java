package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.dtos.MoveDTO;

import java.util.Map;

public class MoveDtoBuilder {

    private MoveDTO moveDTO;

    private MoveDtoBuilder() {
        this.moveDTO = new MoveDTO();
    }

    public static MoveDtoBuilder builder() {
        return new MoveDtoBuilder();
    }

    public MoveDtoBuilder playerName(String value) {
        this.moveDTO.setPlayer(value);
        return this;
    }

    public MoveDtoBuilder fields(Map<String,String> fields){
        this.moveDTO.setValues(fields);
        return this;
    }

    public MoveDTO build(){
        return this.moveDTO;
    }
}
