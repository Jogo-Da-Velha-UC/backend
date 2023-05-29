package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.model.GameStruct;

import java.util.Date;

public class GameStructBuilder {

    private GameStruct gameStruct;

    private GameStructBuilder() {
        this.gameStruct = new GameStruct();
    }

    public static GameStructBuilder builder() {
        return new GameStructBuilder();
    }
    public GameStructBuilder createFieldsEmpty() {
        this.gameStruct.getFields().put("00", "");
        this.gameStruct.getFields().put("01", "");
        this.gameStruct.getFields().put("02", "");
        this.gameStruct.getFields().put("10", "");
        this.gameStruct.getFields().put("11", "");
        this.gameStruct.getFields().put("12", "");
        this.gameStruct.getFields().put("20", "");
        this.gameStruct.getFields().put("21", "");
        this.gameStruct.getFields().put("22", "");
        return this;
    }

    public GameStructBuilder createdAt(){
        this.gameStruct.setCreatedAt(new Date(System.currentTimeMillis()));
        return this;
    }

    public GameStructBuilder updatedAt(){
        this.gameStruct.setUpdatedAt(new Date(System.currentTimeMillis()));
        return this;
    }

    public GameStruct build(){
        return this.gameStruct;
    }
}
