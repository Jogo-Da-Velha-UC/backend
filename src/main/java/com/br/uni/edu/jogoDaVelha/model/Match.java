package com.br.uni.edu.jogoDaVelha.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatch;
    @OneToOne
    private Player playerOne;
    @OneToOne
    private Player playerTwo;
    @OneToOne
    private GameStruct gameStruct;
    @OneToOne
    private StatusMatch statusMatch;
    @OneToOne
    private Player startedWith;
    @OneToMany
    private List<Move> moveList = new ArrayList<>();
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public Match() {
    }

    public Long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Long idMatch) {
        this.idMatch = idMatch;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public GameStruct getGameStruct() {
        return gameStruct;
    }

    public void setGameStruct(GameStruct gameStruct) {
        this.gameStruct = gameStruct;
    }

    public StatusMatch getStatusMatch() {
        return statusMatch;
    }

    public void setStatusMatch(StatusMatch statusMatch) {
        this.statusMatch = statusMatch;
    }

    public Player getStartedWith() {
        return startedWith;
    }

    public void setStartedWith(Player startedWith) {
        this.startedWith = startedWith;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
