//package com.br.uni.edu.jogoDaVelha.resourceTest;
//
//import com.br.uni.edu.jogoDaVelha.repositories.GameStructRepository;
//import com.br.uni.edu.jogoDaVelha.repositories.MatchRepository;
//import com.br.uni.edu.jogoDaVelha.repositories.StatusMatchRepository;
//import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;
//import com.br.uni.edu.jogoDaVelha.service.PlayerService;
//import com.br.uni.edu.jogoDaVelha.service.impl.MatchServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//
//@SpringBootTest
//public class GameIntegrationTest {
//
//    @InjectMocks
//    MatchServiceImpl matchService;
//    @MockBean
//    private  PlayerService playerService;
//    @MockBean
//    private  MatchRepository matchRepository;
//    @MockBean
//    private  GameStructRepository gameStructRepository;
//    @MockBean
//    private  StatusMatchRepository statusMatchRepository;
//
//    @BeforeEach
//    public void setup(){
//        matchService = new MatchServiceImpl(playerService,matchRepository,gameStructRepository,statusMatchRepository, matchMapper);
//    }
//
//    @Test
//    void createGame() throws Exception {
//
//        CreateGameRequest createGameRequest = new CreateGameRequest();
//        createGameRequest.setPlayer("nicolas");
//        matchService.createMatch(createGameRequest);
//    }
//
//}
