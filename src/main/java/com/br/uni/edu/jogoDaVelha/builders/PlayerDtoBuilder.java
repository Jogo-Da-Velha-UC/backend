package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.dtos.MatchDTO;
import com.br.uni.edu.jogoDaVelha.dtos.PlayerDto;
import com.br.uni.edu.jogoDaVelha.enums.StatusPlayerEnum;
import com.br.uni.edu.jogoDaVelha.model.Player;

import java.util.Date;

public class PlayerDtoBuilder {

    private PlayerDto player;

    private PlayerDtoBuilder(){
        player = new PlayerDto();
    }

    public static PlayerDtoBuilder builder(){
        return new PlayerDtoBuilder();
    }

    public PlayerDtoBuilder nickName(String value){
        this.player.setNickName(value);
        return this;
    }

    public PlayerDtoBuilder id(Long value){
        this.player.setPlayerId(value);
        return this;
    }

    public PlayerDtoBuilder email(String value){
        this.player.setEmail(value);
        return this;
    }
    public PlayerDtoBuilder active(Boolean value){
        this.player.setActive(value);
        return this;
    }
    public PlayerDtoBuilder createdAt(Date value){
        this.player.setCreatedAt(value);
        return this;
    }
    public PlayerDtoBuilder updatedAt(Date value){
        this.player.setUpdatedAt(value);
        return this;
    }
    public PlayerDtoBuilder status(StatusPlayerEnum value){
        this.player.setStatus(value);
        return this;
    }
    public PlayerDto build()
    {
        return this.player;
    }
}
