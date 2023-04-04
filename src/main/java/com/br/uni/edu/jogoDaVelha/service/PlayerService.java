package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.model.Player;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayerService {

    public void deletePlayer(Long id) throws Exception;

    public Player savePlayer(Player player) throws Exception;

    public List<Player> findAll();

    public Player updatePlayer(Long id, Player player) throws Exception;

    public Player findById(Long id) throws Exception;
}
