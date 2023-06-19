package com.br.uni.edu.jogoDaVelha.resourceTest;

import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;
import com.br.uni.edu.jogoDaVelha.requests.MoveRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class GameIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createGame() throws Exception {

        CreateGameRequest createGameRequest = new CreateGameRequest();
        createGameRequest.setPlayerOne("nicolas");
        createGameRequest.setPlayerTwo("joao");

        mockMvc.perform(post("/api/v1/game/create-game")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createGameRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void makeMove() throws Exception {

        MoveRequest moveRequest = new MoveRequest();
        moveRequest.setRol("0");
        moveRequest.setCol("1");
        moveRequest.setMatchId(3L);
        moveRequest.setPlayer("joao");
        mockMvc.perform(post("/api/v1/game/make-move")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(moveRequest)))
                .andExpect(status().isOk());

    }

}
