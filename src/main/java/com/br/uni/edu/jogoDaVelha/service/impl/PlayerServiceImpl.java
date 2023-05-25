package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.builders.PlayerBuilder;
import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.repositories.PlayerRepository;
import com.br.uni.edu.jogoDaVelha.requests.CreatePlayerRequest;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void deletePlayer(Long id) throws Exception {
        try {
            if (id == null) {
                throw new Exception(String.format("Id %s not found", id));
            }

            final Player byId = findById(id);
            byId.setDeletedAt(new Date());
            byId.setActive(Boolean.FALSE);
            playerRepository.save(byId);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Player savePlayer(CreatePlayerRequest playerRequest) throws Exception {
        try {
            if (ObjectUtils.isEmpty(playerRequest)) {
                throw new Exception(String.format("Player cannot null"));
            }

            Player player = PlayerBuilder.builder()
                    .nickName(playerRequest.getNickname())
                    .email(playerRequest.getEmail())
                    .password(new String(Base64.getEncoder().encode(playerRequest.getPassword().getBytes())))
                    .active(Boolean.TRUE)
                    .updatedAt(new Date())
                    .createdAt(new Date())
                    .build();

            return playerRepository.save(player);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Player> findAll() {
        List<Player> all = new ArrayList<>();
        for (Player player:
                playerRepository.findAll()) {
            if (player.getActive() == Boolean.TRUE){
                all.add(player);
            }
        };

        return all;
    }

    @Override
    public Player updatePlayer(Long id, Player player) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id cannot be null!");
            }

            Player playerUpdt = playerRepository.findById(id).orElseThrow();

            if (playerRepository.findByEmail(player.getEmail()).isPresent() &&
                    playerUpdt.getNickName().equals(player.getNickName())){
                playerUpdt.setEmail(player.getEmail());
                playerUpdt.setNickName(player.getNickName());
                return playerRepository.save(playerUpdt);
            }

            throw new Exception("Email in use!");


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Player findById(Long id) throws Exception {
        try {
            return playerRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new Exception(String.format("Id %s not found", id));
        }
    }
    @Override
    public Player findByUsername(String nickName) throws Exception {
        try {
            return playerRepository.findByNickName(nickName).orElseThrow();
        } catch (Exception e) {
            throw new Exception(String.format("UserName %s not found", nickName));
        }
    }


}
