package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.builders.MoveBuilder;
import com.br.uni.edu.jogoDaVelha.enums.StatusMatchEnum;
import com.br.uni.edu.jogoDaVelha.model.*;
import com.br.uni.edu.jogoDaVelha.repositories.GameStructRepository;
import com.br.uni.edu.jogoDaVelha.repositories.MatchRepository;
import com.br.uni.edu.jogoDaVelha.repositories.MoveRepository;
import com.br.uni.edu.jogoDaVelha.requests.MoveRequest;
import com.br.uni.edu.jogoDaVelha.service.GameStructService;
import com.br.uni.edu.jogoDaVelha.service.MatchService;
import com.br.uni.edu.jogoDaVelha.service.MoveService;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MoveServiceImpl implements MoveService {

    private final MoveRepository moveRepository;
    private final GameStructRepository gameStructRepository;
    private final MatchRepository matchRepository;
    private final MatchService matchService;
    private final PlayerService playerService;
    private final GameStructService gameStructService;

    public MoveServiceImpl(MoveRepository moveRepository, GameStructRepository gameStructRepository, MatchRepository matchRepository, MatchService matchService, PlayerService playerService, GameStructService gameStructService) {
        this.moveRepository = moveRepository;
        this.gameStructRepository = gameStructRepository;
        this.matchRepository = matchRepository;
        this.matchService = matchService;
        this.playerService = playerService;
        this.gameStructService = gameStructService;
    }

    @Override
    public Match makeMove(MoveRequest moveRequest) throws Exception {

        try {

            final Match match = matchRepository.findById(moveRequest.getMatchId()).orElseThrow(()
                    -> new Exception("GAME NOT FOUND!!!"));

            if (match.getPlayerOne() == null || match.getPlayerTwo() == null) {
                throw new Exception("INVALID MATCH.");
            }

            final GameStruct gameStruct = match.getGameStruct();

            final Player player = playerService.findByUsername(moveRequest.getPlayerOne());

            final String symbol = getPlayerSymbol(player, match);

            final String key = getKey(moveRequest);

            positionIsValid(gameStruct, key);

            populateMatchWithFirtsPlayer(match, player);

            checkIfPlayerIsEligibleToPlay(match, player);

            match.getMoveList().add(createMove(match, player, key, symbol));

            gameStruct.getFields().put(key, symbol);
            gameStructRepository.save(gameStruct);

            if (gameStructService.checkWin(symbol, gameStruct)) {
                matchService.populateMatchWithWinner(match, StatusMatchEnum.FINISHED);
                return match;
            }

            if (gameStructService.checkDrawn(gameStruct)) {
                matchService.populateMatchWithDrawn(match, StatusMatchEnum.DRAW);
                return match;
            }

            matchRepository.save(match);
            return match;

        } catch (Exception exc) {
            throw new Exception(exc);
        }
    }

    private void positionIsValid(GameStruct gameStruct, String key) throws Exception {
        if (!gameStructService.isPositionEmpty(gameStruct, key)) {
            throw new Exception("INVALID MOVE.");
        }
    }

    private void checkIfPlayerIsEligibleToPlay(Match match, Player player) throws Exception {
        if (!match.getMoveList().isEmpty()) {
            if (player == match.getMoveList().get(match.getMoveList().size() - 1).getCurrentPlayer()) {
                throw new Exception("IT'S NOT THIS PLAYER'S TURN.");
            }
        }
    }

    private void populateMatchWithFirtsPlayer(Match match, Player player) {
        if(match.getMoveList().isEmpty()){
            match.setStartedWith(player);
        }
    }


    private String getKey(MoveRequest moveRequest) {
        return moveRequest.getRol().concat(moveRequest.getCol());
    }

    private String getPlayerSymbol(Player player, Match match) {
        return player == match.getPlayerOne() ? "X" : "O";
    }

    private Move createMove(Match match, Player player, String key, String symbol) {
        final Move move = MoveBuilder.builder()
                .currentPlayer(player)
                .fields(makeField(key, symbol))
                .match(match)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        moveRepository.save(move);
        return move;
    }

    private Map<String, String> makeField(String key, String symbol) {
        Map<String, String> values = new HashMap<>();
        values.put(key, symbol);
        return values;
    }
}
