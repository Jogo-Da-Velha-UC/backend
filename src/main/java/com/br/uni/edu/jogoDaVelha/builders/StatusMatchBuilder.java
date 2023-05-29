package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.enums.StatusMatchEnum;
import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.model.StatusMatch;

import java.util.Date;

public class StatusMatchBuilder {

    private StatusMatch statusMatch;

    private StatusMatchBuilder() {
        this.statusMatch = new StatusMatch();
    }

    public static StatusMatchBuilder builder() {
        return new StatusMatchBuilder();
    }

    public StatusMatchBuilder winner(Player player) {
        this.statusMatch.setWinner(player);
        return this;
    }

    public StatusMatchBuilder statusMatch(StatusMatchEnum statusMatchEnum) {
        this.statusMatch.setStatusMatchEnum(statusMatchEnum);
        return this;
    }

    public StatusMatchBuilder createdAt() {
        this.statusMatch.setCreatedAt(new Date());
        return this;
    }

    public StatusMatchBuilder updatedAt(){
        this.statusMatch.setUpdatedAt(new Date());
        return this;
    }
    public StatusMatch build(){
        return this.statusMatch;
    }
}
