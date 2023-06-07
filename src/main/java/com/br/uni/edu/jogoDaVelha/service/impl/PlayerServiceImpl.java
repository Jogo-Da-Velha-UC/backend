package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.builders.PlayerBuilder;
import com.br.uni.edu.jogoDaVelha.dtos.PlayerDto;
import com.br.uni.edu.jogoDaVelha.enums.StatusPlayerEnum;
import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.repositories.PlayerRepository;
import com.br.uni.edu.jogoDaVelha.requests.CreatePlayerRequest;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final ModelMapper modelMapper;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void deletePlayer(Long id) throws Exception {
        try {
            if (id == null) {
                throw new Exception(String.format("Id %s not found", id));
            }

            final Player byId = playerRepository.findById(id).orElseThrow(() -> new Exception("Player Not Found"));
            byId.setDeletedAt(new Date());
            byId.setActive(Boolean.FALSE);
            playerRepository.save(byId);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PlayerDto savePlayer(CreatePlayerRequest playerRequest) throws Exception {
        try {
            if (ObjectUtils.isEmpty(playerRequest)) {
                throw new Exception(String.format("Player cannot null"));
            }

            Player player = PlayerBuilder.builder()
                    .nickName(playerRequest.getNickname())
                    .email(playerRequest.getEmail())
                    .password(new String(Base64.getEncoder().encode(playerRequest.getPassword().getBytes())))
                    .active(Boolean.TRUE)
                    .status(StatusPlayerEnum.ACTIVE)
                    .updatedAt(new Date())
                    .createdAt(new Date())
                    .build();
            playerRepository.save(player);
            return modelMapper.map(player, PlayerDto.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<PlayerDto> findAll() {
        return playerRepository.findAll().stream().map(x -> modelMapper.map(x, PlayerDto.class)).collect(Collectors.toList());
    }

    @Override
    public PlayerDto updatePlayer(Long id, Player player) throws Exception {
        try {
            if (id == null) {
                throw new Exception("id cannot be null!");
            }

            Player playerUpdt = playerRepository.findById(id).orElseThrow();

            if (playerRepository.findByEmail(player.getEmail()).isPresent() &&
                    playerUpdt.getNickName().equals(player.getNickName())) {
                playerUpdt.setEmail(player.getEmail());
                playerUpdt.setNickName(player.getNickName());
                playerRepository.save(player);
                return modelMapper.map(player, PlayerDto.class);
            }

            throw new Exception("Email in use!");


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PlayerDto findById(Long id) throws Exception {
        try {
            final Player player = playerRepository.findById(id).orElseThrow();
            return modelMapper.map(player, PlayerDto.class);
        } catch (Exception e) {
            throw new Exception(String.format("Id %s not found", id));
        }
    }

    @Override
    public Player findByUsername(String nickName) throws Exception {
        try {
            final Player player = playerRepository.findByNickName(nickName).orElseThrow();
            return player;
        } catch (Exception e) {
            throw new Exception(String.format("UserName %s not found", nickName));
        }
    }


}
