package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.model.*;

import java.util.Date;

public class MatchBuilder {

    private Match match;

    private MatchBuilder(){
        match = new Match();
    }

    public static MatchBuilder builder(){
        return new MatchBuilder();
    }

    public MatchBuilder playerOne(Player playerOne){
        this.match.setPlayerOne(playerOne);
        return this;
    }
    public MatchBuilder playerTwo(Player playerTwo){
        this.match.setPlayerTwo(playerTwo);
        return this;
    }
    public MatchBuilder gameStruct(GameStruct gameStruct){
        this.match.setGameStruct(gameStruct);
        return this;
    }
    public MatchBuilder statusMatch(StatusMatch statusMatch){
        this.match.setStatusMatch(statusMatch);
        return this;
    }
    public MatchBuilder addMoveInList(Move move){
        this.match.getMoveList().add(move);
        return this;
    }
    public MatchBuilder createdAt(){
        this.match.setCreatedAt(new Date());
        return this;
    }
    public MatchBuilder updateAt(){
        this.match.setUpdatedAt(new Date());
        return this;
    }
    public Match build(){
        return this.match;
    }
}
