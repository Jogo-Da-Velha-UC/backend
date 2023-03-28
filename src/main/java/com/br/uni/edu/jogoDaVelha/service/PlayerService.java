package com.br.uni.edu.jogoDaVelha.service;

import com.br.uni.edu.jogoDaVelha.model.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {

    public void deletePlayer(Long id) throws Exception;

    public Player savePlayer(Player player) throws Exception;

    public List<Player> findAll();

    public Player updatePlayer(Long id, Player player) throws Exception;

    public Player findById(Long id) throws Exception;
}
