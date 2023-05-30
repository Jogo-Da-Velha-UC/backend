package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.model.GameStruct;
import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.model.Move;
import com.br.uni.edu.jogoDaVelha.model.Player;

public interface GameStructService {

    Boolean isPositionEmpty(GameStruct gameStruct, String key);
    Boolean checkWin(String symbol, GameStruct gameStruct);
    public Boolean checkDrawn(GameStruct gameStruct);
}
