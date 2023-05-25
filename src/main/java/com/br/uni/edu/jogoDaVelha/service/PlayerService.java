package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.requests.CreatePlayerRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayerService {

    void deletePlayer(Long id) throws Exception;

    Player savePlayer(CreatePlayerRequest playerRequest) throws Exception;

    List<Player> findAll();

    Player updatePlayer(Long id, Player player) throws Exception;

    Player findById(Long id) throws Exception;
    Player findByUsername(String userName) throws Exception;
}
