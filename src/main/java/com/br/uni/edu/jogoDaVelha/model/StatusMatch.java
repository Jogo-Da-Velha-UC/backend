package com.br.uni.edu.jogoDaVelha.model;

import com.br.uni.edu.jogoDaVelha.enums.StatusMatchEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "tb_status_matches")
public class StatusMatch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusMatchId;
    @OneToOne
    private Player winner;
    @Enumerated
    private StatusMatchEnum statusMatchEnum;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public StatusMatch() {
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public StatusMatchEnum getStatusMatchEnum() {
        return statusMatchEnum;
    }

    public void setStatusMatchEnum(StatusMatchEnum statusMatchEnum) {
        this.statusMatchEnum = statusMatchEnum;
    }

    public Long getStatusMatchId() {
        return statusMatchId;
    }

    public void setStatusMatchId(Long statusMatchId) {
        this.statusMatchId = statusMatchId;
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
