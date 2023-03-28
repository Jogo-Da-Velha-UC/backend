package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.repositories.PlayerRepository;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    @Override
    public void deletePlayer(Long id)  throws Exception{
        try {
            if (id == null){
                throw new Exception();
            }

            playerRepository.deleteById(id);

        } catch (Exception e) {
            throw new Exception(String.format("Id %s not found", id));
        }
    }

    @Override
    public Player savePlayer(Player player)  throws Exception{
        try {
            if (ObjectUtils.isEmpty(player)) {
                throw new Exception();
            }
            return playerRepository.save(player);
        } catch (Exception e) {
            throw new Exception(String.format("Player cannot null"));
        }
    }

    @Override
    public List<Player> findAll() {
       return playerRepository.findAll();
    }

    @Override
    public Player updatePlayer(Long id, Player player) throws Exception {
        try {
            if (id == null){
                throw new Exception("id nao pode ser vazio!");
            }

            Player playerUpdt = playerRepository.findById(id).get();
            playerUpdt.setEmail(player.getEmail());
            playerUpdt.setNickname(player.getNickname());
            return playerRepository.save(playerUpdt);

        } catch (Exception e) {
            throw new Exception(String.format("Id %s not found", id));
        }
    }

    @Override
    public Player findById(Long id) throws Exception {
        try {
            return playerRepository.findById(id).get();
        }catch (Exception e) {
            throw new Exception(String.format("Id %s not found", id));
        }
    }
}
