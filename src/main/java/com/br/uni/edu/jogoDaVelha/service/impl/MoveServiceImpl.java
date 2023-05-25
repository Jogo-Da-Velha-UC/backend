package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.builders.MoveBuilder;
import com.br.uni.edu.jogoDaVelha.model.GameStruct;
import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.model.Move;
import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.repositories.GameStructRepository;
import com.br.uni.edu.jogoDaVelha.repositories.MatchRepository;
import com.br.uni.edu.jogoDaVelha.repositories.MoveRepository;
import com.br.uni.edu.jogoDaVelha.requests.MoveRequest;
import com.br.uni.edu.jogoDaVelha.service.GameStructService;
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
    private final PlayerService playerService;
    private final GameStructService gameStructService;

    public MoveServiceImpl(MoveRepository moveRepository, GameStructRepository gameStructRepository, MatchRepository matchRepository, PlayerService playerService, GameStructService gameStructService) {
        this.moveRepository = moveRepository;
        this.gameStructRepository = gameStructRepository;
        this.matchRepository = matchRepository;
        this.playerService = playerService;
        this.gameStructService = gameStructService;
    }

    @Override
    public Match makeMove(MoveRequest moveRequest) throws Exception {

        Match match = matchRepository.findById(moveRequest.getMatchId()).orElseThrow();

        GameStruct gameStruct = match.getGameStruct();

        Player player = playerService.findByUsername(moveRequest.getPlayerOne());

        String symbol = getPlayerSymbol(player, match);

        Move move = createMove(match, player, moveRequest.getRol(), moveRequest.getCol(), symbol);

        String key = moveRequest.getRol().concat(moveRequest.getCol());

        // Verifica se a jogada é válida
        if (!gameStructService.isPositionEmpty(gameStruct, moveRequest.getRol(), moveRequest.getCol())) {
            throw new Exception("JOGADA INVALIDA.");
        }

        String field = gameStruct.getFields().get(key);
        field = symbol;
        gameStructRepository.save(gameStruct);

        if (player != move.getCurrentPlayer()) {
            throw new Exception("NÃO É A VEZ DESSE JOGADOR.");
        }

        // Adiciona a jogada à lista de movimentos
        match.getMoveList().add(move);

        // Verifica se houve um vencedor
        if (checkWin(symbol, match)) {
            return match;
        }

        // Verifica se houve empate
        if (checkDrawn(match)) {
            return match;
        }

        return null;
    }

    private boolean checkWin(String symbol, Match match) {
        Map<String, String> fields = match.getGameStruct().getFields();

        if (fields.get("00") == symbol && fields.get("01") == symbol && fields.get("02") == symbol) {
            return true;
        }
        if (fields.get("00") == symbol && fields.get("10") == symbol && fields.get("20") == symbol) {
            return true;
        }
        if (fields.get("00") == symbol && fields.get("11") == symbol && fields.get("22") == symbol) {
            return true;
        }
        if (fields.get("02") == symbol && fields.get("11") == symbol && fields.get("20") == symbol) {
            return true;
        }

        return false;
    }

    private Boolean checkDrawn(Match match) {
        Map<String, String> fields = match.getGameStruct().getFields();
        for (String key : fields.keySet()) {
            if (key.isBlank()) {
                return false;
            }
        }
        return true;
    }

    private String getPlayerSymbol(Player player, Match match) {
        return player == match.getPlayerOne() ? "X" : "O";
    }

    private Move createMove(Match match, Player player, String rol, String col, String symbol) {
        Move move = MoveBuilder.builder()
                .currentPlayer(player)
                .fields(makeField(rol, col, symbol))
                .match(match)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        moveRepository.save(move);
        return move;
    }

    private Map<String, String> makeField(String rol, String col, String symbol) {
        Map<String, String> values = new HashMap<>();
        String key = rol.concat(col);
        values.put(key, symbol);
        return values;
    }
}
