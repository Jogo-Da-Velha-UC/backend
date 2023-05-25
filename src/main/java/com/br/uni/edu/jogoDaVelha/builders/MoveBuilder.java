package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.model.Move;
import com.br.uni.edu.jogoDaVelha.model.Player;

import java.util.Date;
import java.util.Map;

public class MoveBuilder {

    private Move move;

    private MoveBuilder(){
        this.move = new Move();
    }
    public static MoveBuilder builder(){
        return new MoveBuilder();
    }

    public MoveBuilder createdAt(Date value){
        this.move.setCreatedAt(value);
        return this;
    }
    public MoveBuilder updatedAt(Date value){
        this.move.setUpdatedAt(value);
        return this;
    }
    public MoveBuilder currentPlayer(Player player){
        this.move.setCurrentPlayer(player);
        return this;
    }

    public MoveBuilder match(Match match){
        this.move.setMatch(match);
        return this;
    }
    public MoveBuilder fields(Map<String,String> fields){
        this.move.setValuesPlayed(fields);
        return this;
    }
    public Move build(){
        return this.move;
    }

}
