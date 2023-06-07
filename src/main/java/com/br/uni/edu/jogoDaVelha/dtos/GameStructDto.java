package com.br.uni.edu.jogoDaVelha.dtos;

import java.util.Date;
import java.util.Map;

public class GameStructDto {

    private Long gameStructId;
    private Map<String, String> fields;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public GameStructDto() {
    }

    public Long getGameStructId() {
        return gameStructId;
    }

    public void setGameStructId(Long gameStructId) {
        this.gameStructId = gameStructId;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
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
