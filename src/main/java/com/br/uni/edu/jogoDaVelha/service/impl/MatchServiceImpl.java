package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.builders.GameStructBuilder;
import com.br.uni.edu.jogoDaVelha.builders.MatchBuilder;
import com.br.uni.edu.jogoDaVelha.builders.StatusMatchBuilder;
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
    public Match createMatch(CreateGameRequest createGameRequest) throws Exception {

        try {

            Match match = null;

            Player player = playerService.findByUsername(createGameRequest.getPlayer());

            if (player == null) {
                throw new Exception("YOU NEED ONE PLAYER TO CREATE THE MATCH!");
            }

            GameStruct gameStruct = createGameStruct();

            StatusMatch statusMatch = createStatusMatch();

            if(findMatch() == null){
                match = MatchBuilder.builder()
                        .playerOne(player)
                        .gameStruct(gameStruct)
                        .statusMatch(statusMatch)
                        .createdAt()
                        .updateAt()
                        .build();
            }else{
                match = findMatch();
                if(match.getPlayerOne() != null) {
                    populateMatchWithOtherPlayer(match, player);
                }
            }

            return matchRepository.save(match);
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
        StatusMatch statusMatch = StatusMatchBuilder.builder()
                .statusMatch(statusMatchEnum)
                .createdAt()
                .updatedAt()
                .build();

        statusMatchRepository.save(statusMatch);

        match.setStatusMatch(statusMatch);
    }
    private void populateMatchWithOtherPlayer(Match match, Player player) {
        match.setPlayerTwo(player);
        match.setUpdatedAt(new Date());
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

    @Override
    public void populateMatchWithWinner(Match match, StatusMatchEnum statusMatchEnum) {
        final int size = match.getMoveList().size();
        final Move move = match.getMoveList().get(size - 1);
        StatusMatch statusMatch = StatusMatchBuilder.builder()
                .statusMatch(statusMatchEnum)
                .winner(move.getCurrentPlayer())
                .createdAt()
                .updatedAt()
                .build();

        statusMatchRepository.save(statusMatch);

        match.setStatusMatch(statusMatch);
    }
}
