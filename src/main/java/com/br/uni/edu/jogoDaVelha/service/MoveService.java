package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.requests.MoveRequest;

public interface MoveService {

    Match makeMove(MoveRequest moveRequest) throws Exception;

}
