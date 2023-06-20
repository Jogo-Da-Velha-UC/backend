package com.br.uni.edu.jogoDaVelha.dtos;

import com.br.uni.edu.jogoDaVelha.enums.StatusMatchEnum;

import java.io.Serializable;
import java.util.Date;

public class StatusMatchDto implements Serializable {

    private Long statusMatchId;
    private PlayerDto winner;
    private StatusMatchEnum statusMatchEnum;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public StatusMatchDto() {
    }

    public Long getStatusMatchId() {
        return statusMatchId;
    }

    public void setStatusMatchId(Long statusMatchId) {
        this.statusMatchId = statusMatchId;
    }

    public PlayerDto getWinner() {
        return winner;
    }

    public void setWinner(PlayerDto winner) {
        this.winner = winner;
    }

    public StatusMatchEnum getStatusMatchEnum() {
        return statusMatchEnum;
    }

    public void setStatusMatchEnum(StatusMatchEnum statusMatchEnum) {
        this.statusMatchEnum = statusMatchEnum;
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
