package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.builders.GameStructBuilder;
import com.br.uni.edu.jogoDaVelha.builders.MatchBuilder;
import com.br.uni.edu.jogoDaVelha.builders.MatchDtoBuilder;
import com.br.uni.edu.jogoDaVelha.builders.StatusMatchBuilder;
import com.br.uni.edu.jogoDaVelha.dtos.MatchDTO;
import com.br.uni.edu.jogoDaVelha.enums.StatusMatchEnum;
import com.br.uni.edu.jogoDaVelha.model.*;
import com.br.uni.edu.jogoDaVelha.repositories.GameStructRepository;
import com.br.uni.edu.jogoDaVelha.repositories.MatchRepository;
import com.br.uni.edu.jogoDaVelha.repositories.StatusMatchRepository;
import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;
import com.br.uni.edu.jogoDaVelha.service.MatchService;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MatchServiceImpl implements MatchService {
    private final PlayerService playerService;
    private final MatchRepository matchRepository;
    private final GameStructRepository gameStructRepository;
    private final StatusMatchRepository statusMatchRepository;

    public MatchServiceImpl(PlayerService playerService, MatchRepository matchRepository, GameStructRepository gameStructRepository, StatusMatchRepository statusMatchRepository) {
        this.playerService = playerService;
        this.matchRepository = matchRepository;
        this.gameStructRepository = gameStructRepository;
        this.statusMatchRepository = statusMatchRepository;
    }

    @Override
    public MatchDTO createMatch(CreateGameRequest createGameRequest) throws Exception {

        try {

            Match match = null;

            Player player = playerService.findByUsername(createGameRequest.getPlayer());

            if (player == null) {
                throw new Exception("YOU NEED ONE PLAYER TO CREATE THE MATCH!");
            }

            if (findMatch() == null) {

                GameStruct gameStruct = createGameStruct();

                StatusMatch statusMatch = createStatusMatch();

                match = MatchBuilder.builder()
                        .playerOne(player)
                        .gameStruct(gameStruct)
                        .statusMatch(statusMatch)
                        .createdAt()
                        .updateAt()
                        .build();
            } else {
                match = findMatch();
                if (match.getPlayerOne() != null) {
                    populateMatchWithOtherPlayer(match, player);
                }
            }

            matchRepository.save(match);

            return MatchDtoBuilder.builder()
                    .matchId(match.getIdMatch())
                    .status(match.getStatusMatch().getStatusMatchEnum().name()).build();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Match findMatch() {
        try {
            return matchRepository.findMatchWithOneOnlyPlayer();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void populateMatchWithDrawn(Match match, StatusMatchEnum statusMatchEnum) {
        StatusMatch statusMatch = match.getStatusMatch();
        statusMatch.setStatusMatchEnum(StatusMatchEnum.DRAW);
        statusMatchRepository.save(statusMatch);
    }

    private void populateMatchWithOtherPlayer(Match match, Player player) {
        match.setPlayerTwo(player);
        match.setUpdatedAt(new Date());
        match.setStatusMatch(updateStatusMatch(match.getStatusMatch()));
    }

    private GameStruct createGameStruct() {
        GameStruct gameStruct = GameStructBuilder.builder()
                .createFieldsEmpty()
                .createdAt()
                .updatedAt()
                .build();

        gameStructRepository.save(gameStruct);

        return gameStruct;
    }

    private StatusMatch createStatusMatch() {
        StatusMatch statusMatch = StatusMatchBuilder.builder()
                .statusMatch(StatusMatchEnum.WAITING_FOR_PLAYER)
                .createdAt()
                .updatedAt()
                .build();

        statusMatchRepository.save(statusMatch);
        return statusMatch;
    }

    private StatusMatch updateStatusMatch(StatusMatch statusOld) {
        StatusMatch statusNew = statusOld;
        statusNew.setStatusMatchEnum(StatusMatchEnum.ACTIVE);
        statusMatchRepository.save(statusNew);
        return statusNew;
    }

    @Override
    public void populateMatchWithWinner(Match match, StatusMatchEnum statusMatchEnum) {
        final int size = match.getMoveList().size();
        final Move move = match.getMoveList().get(size - 1);
        StatusMatch statusMatch = match.getStatusMatch();
        statusMatch.setStatusMatchEnum(statusMatchEnum);
        statusMatch.setWinner(move.getCurrentPlayer());
        statusMatchRepository.save(statusMatch);
    }
}
