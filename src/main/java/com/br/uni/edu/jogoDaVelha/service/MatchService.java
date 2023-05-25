package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;

public interface MatchService {

    Match createMatch(CreateGameRequest createGameRequest) throws Exception;
}
