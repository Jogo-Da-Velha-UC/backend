package com.br.uni.edu.jogoDaVelha.dtos;

import com.br.uni.edu.jogoDaVelha.model.Move;

import java.util.List;

public class MatchDTO {

    private Long matchId;
    private String playerOne;
    private String playerTwo;
    private List<MoveDTO> moveList;
    private String statusMatch;
    private String winner;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public List<MoveDTO> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<MoveDTO> moveList) {
        this.moveList = moveList;
    }

    public String getStatusMatch() {
        return statusMatch;
    }

    public void setStatusMatch(String statusMatch) {
        this.statusMatch = statusMatch;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
