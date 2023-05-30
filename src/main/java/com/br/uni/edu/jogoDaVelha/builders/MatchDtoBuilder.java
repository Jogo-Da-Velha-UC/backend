package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.dtos.MatchDTO;
import com.br.uni.edu.jogoDaVelha.dtos.MoveDTO;
import com.br.uni.edu.jogoDaVelha.model.Move;

import java.util.List;

public class MatchDtoBuilder {

    private MatchDTO matchDTO;

    private MatchDtoBuilder(){
        this.matchDTO = new MatchDTO();
    }
    public static MatchDtoBuilder builder(){
        return new MatchDtoBuilder();
    }

    public MatchDtoBuilder matchId(Long value){
        this.matchDTO.setMatchId(value);
        return this;
    }
    public MatchDtoBuilder playerOne(String value){
        this.matchDTO.setPlayerOne(value);
        return this;
    }
    public MatchDtoBuilder playerTwo(String value){
        this.matchDTO.setPlayerTwo(value);
        return this;
    }
    public MatchDtoBuilder status(String value){
        this.matchDTO.setStatusMatch(value);
        return this;
    }
    public MatchDtoBuilder moves(List<MoveDTO> value){
        this.matchDTO.setMoveList(value);
        return this;
    }
    public MatchDtoBuilder winner(String value){
        this.matchDTO.setWinner(value);
        return this;
    }

    public MatchDTO build(){
        return this.matchDTO;
    }
}
