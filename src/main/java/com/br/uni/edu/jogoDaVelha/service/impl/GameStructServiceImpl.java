package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.model.GameStruct;
import com.br.uni.edu.jogoDaVelha.service.GameStructService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GameStructServiceImpl implements GameStructService {
    @Override
    public Boolean isPositionEmpty(GameStruct gameStruct, String key) {
        return gameStruct.getFields().get(key).isEmpty();
    }

    @Override
    public Boolean checkWin(String symbol, GameStruct gameStruct) {
        Map<String, String> fields = gameStruct.getFields();

        if (fields.get("00").equals(symbol) && fields.get("01").equals(symbol) && fields.get("02").equals(symbol)) {
            return true;
        }
        if (fields.get("00").equals(symbol) && fields.get("10").equals(symbol) && fields.get("20").equals(symbol)) {
            return true;
        }
        if (fields.get("00").equals(symbol) && fields.get("11").equals(symbol) && fields.get("22").equals(symbol)) {
            return true;
        }
        if (fields.get("02").equals(symbol) && fields.get("11").equals(symbol) && fields.get("20").equals(symbol)) {
            return true;
        }
        if (fields.get("10").equals(symbol) && fields.get("11").equals(symbol) && fields.get("12").equals(symbol)) {
            return true;
        }
        if (fields.get("20").equals(symbol) && fields.get("21").equals(symbol) && fields.get("22").equals(symbol)) {
            return true;
        }
        if (fields.get("01").equals(symbol) && fields.get("11").equals(symbol) && fields.get("21").equals(symbol)) {
            return true;
        }
        if (fields.get("02").equals(symbol) && fields.get("12").equals(symbol) && fields.get("22").equals(symbol)) {
            return true;
        }

        return false;
    }
    @Override
    public Boolean checkDrawn(GameStruct gameStruct) {
        Map<String, String> fields = gameStruct.getFields();
        for (String key : fields.values()) {
            if (key.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
