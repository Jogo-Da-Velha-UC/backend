package com.br.uni.edu.jogoDaVelha.service.impl;

import com.br.uni.edu.jogoDaVelha.builders.MatchBuilder;
import com.br.uni.edu.jogoDaVelha.model.GameStruct;
import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.repositories.GameStructRepository;
import com.br.uni.edu.jogoDaVelha.repositories.MatchRepository;
import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;
import com.br.uni.edu.jogoDaVelha.service.MatchService;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {
    private final PlayerService playerService;
    private final MatchRepository matchRepository;
    private final GameStructRepository gameStructRepository;

    public MatchServiceImpl(PlayerService playerService, MatchRepository matchRepository, GameStructRepository gameStructRepository) {
        this.playerService = playerService;
        this.matchRepository = matchRepository;
        this.gameStructRepository = gameStructRepository;
    }

    @Override
    public Match createMatch(CreateGameRequest createGameRequest) throws Exception {

        try {

            Player player1 = playerService.findByUsername(createGameRequest.getPlayerOne());
            Player player2 = playerService.findByUsername(createGameRequest.getPlayerTwo());


            if (player1 == null || player2 == null) {
                throw new Exception("PRECISA TER OS DOIS JOGADORES PARA CRIA O JOGO!");
            }


            GameStruct gameStruct = new GameStruct();
            gameStructRepository.save(gameStruct);


            Match match = MatchBuilder.builder()
                    .playerOne(player1)
                    .playerTwo(player2)
                    .gameStruct(gameStruct)
                    .createdAt()
                    .updateAt()
                    .build();


            return matchRepository.save(match);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
