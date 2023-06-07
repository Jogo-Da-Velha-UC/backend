package com.br.uni.edu.jogoDaVelha.dtos;

import com.br.uni.edu.jogoDaVelha.enums.StatusPlayerEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;

public class PlayerDto {

    private Long playerId;
    private String nickName;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private Boolean active;
    private StatusPlayerEnum status;

    public PlayerDto() {
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public StatusPlayerEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPlayerEnum status) {
        this.status = status;
    }
}
