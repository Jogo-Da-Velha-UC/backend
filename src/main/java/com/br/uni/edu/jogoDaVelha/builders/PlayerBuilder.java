package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.enums.StatusPlayerEnum;
import com.br.uni.edu.jogoDaVelha.model.Player;

import java.util.Date;

public class PlayerBuilder {

    private Player player;

    private PlayerBuilder(){
        this.player = new Player();
    }
    public static PlayerBuilder builder(){
        return new PlayerBuilder();
    }
    public PlayerBuilder nickName(String value){
        this.player.setNickName(value);
        return this;
    }
    public PlayerBuilder password(String value){
        this.player.setPassword(value);
        return this;
    }
    public PlayerBuilder email(String value){
        this.player.setEmail(value);
        return this;
    }
    public PlayerBuilder active(Boolean value){
        this.player.setActive(value);
        return this;
    }
    public PlayerBuilder createdAt(Date value){
        this.player.setCreatedAt(value);
        return this;
    }
    public PlayerBuilder updatedAt(Date value){
        this.player.setUpdatedAt(value);
        return this;
    }
    public PlayerBuilder status(StatusPlayerEnum value){
        this.player.setStatus(value);
        return this;
    }
    public Player build()
    {
        return this.player;
    }
}
