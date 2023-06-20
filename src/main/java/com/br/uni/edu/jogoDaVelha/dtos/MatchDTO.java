package com.br.uni.edu.jogoDaVelha.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatchDTO implements Serializable {

    private Long matchId;
    private PlayerDto playerOne;
    private PlayerDto playerTwo;
    private List<MoveDTO> moveList = new ArrayList<>();
    private GameStructDto gameStruct;
    private StatusMatchDto statusMatch;

    public MatchDTO() {
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public PlayerDto getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(PlayerDto playerOne) {
        this.playerOne = playerOne;
    }

    public PlayerDto getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(PlayerDto playerTwo) {
        this.playerTwo = playerTwo;
    }

    public List<MoveDTO> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<MoveDTO> moveList) {
        this.moveList = moveList;
    }

    public GameStructDto getGameStruct() {
        return gameStruct;
    }

    public void setGameStruct(GameStructDto gameStruct) {
        this.gameStruct = gameStruct;
    }

    public StatusMatchDto getStatusMatch() {
        return statusMatch;
    }

    public void setStatusMatch(StatusMatchDto statusMatch) {
        this.statusMatch = statusMatch;
    }
}
