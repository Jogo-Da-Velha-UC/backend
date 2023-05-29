package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.enums.StatusMatchEnum;
import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;

public interface MatchService {

    Match createMatch(CreateGameRequest createGameRequest) throws Exception;
    void populateMatchWithDrawn(Match match, StatusMatchEnum statusMatchEnum);
    void populateMatchWithWinner(Match match, StatusMatchEnum statusMatchEnum);
    Match findMatch();
}
