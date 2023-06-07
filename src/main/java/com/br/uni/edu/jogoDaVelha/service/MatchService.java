package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.dtos.MatchDTO;
import com.br.uni.edu.jogoDaVelha.enums.StatusMatchEnum;
import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;

import java.util.List;

public interface MatchService {

    MatchDTO createMatch(CreateGameRequest createGameRequest) throws Exception;
    void populateMatchWithDrawn(Match match, StatusMatchEnum statusMatchEnum);
    void populateMatchWithWinner(Match match, StatusMatchEnum statusMatchEnum);
    Match findMatchWithOnePlayer();
    MatchDTO findMatch(Long id) throws Exception;
    List<MatchDTO> findMatchesByUser(Long id) throws Exception;
}
