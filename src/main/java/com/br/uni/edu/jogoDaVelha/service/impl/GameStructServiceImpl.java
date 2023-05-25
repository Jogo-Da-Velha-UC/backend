package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.model.GameStruct;
import com.br.uni.edu.jogoDaVelha.service.GameStructService;
import org.springframework.stereotype.Service;

@Service
public class GameStructServiceImpl implements GameStructService {
    @Override
    public Boolean isPositionEmpty(GameStruct gameStruct, String rol, String col) {
        String key = rol.concat(col);
        return gameStruct.getFields().get(key).isEmpty();
    }
}
