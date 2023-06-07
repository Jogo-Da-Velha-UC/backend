package com.br.uni.edu.jogoDaVelha.builders;

import com.br.uni.edu.jogoDaVelha.dtos.GameStructDto;
import com.br.uni.edu.jogoDaVelha.dtos.MatchDTO;
import com.br.uni.edu.jogoDaVelha.dtos.MoveDTO;
import com.br.uni.edu.jogoDaVelha.dtos.PlayerDto;
import com.br.uni.edu.jogoDaVelha.model.Move;
import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.model.StatusMatch;

import java.util.List;
import java.util.Map;

public class MatchDTOBuilder {

    private MatchDTO match;

    private MatchDTOBuilder() {
        match = new MatchDTO();
    }

    public static MatchDTOBuilder builder() {
        return new MatchDTOBuilder();
    }

    public MatchDTOBuilder playerOne(Player playerOne) {
        this.match.setPlayerOne(createPlayerDto(playerOne));
        return this;
    }

    public MatchDTOBuilder matchId(Long id) {
        this.match.setMatchId(id);
        return this;
    }
    public MatchDTOBuilder playerTwo(Player playerTwo) {
        this.match.setPlayerTwo(createPlayerDto(playerTwo));
        return this;
    }

    public MatchDTOBuilder winner(Player winner) {
        this.match.setPlayerTwo(createPlayerDto(winner));
        return this;
    }

    public MatchDTOBuilder gameStruct(GameStructDto fields) {
        this.match.setGameStruct(fields);
        return this;
    }

    public MatchDTOBuilder statusMatch(StatusMatch statusMatch) {
        this.match.setStatusMatch(statusMatch);
        return this;
    }

    public MatchDTOBuilder addMoveInList(List<Move> moves) {
        for (Move move : moves) {
            MoveDTO moveDTO = new MoveDTO();
            moveDTO.setId(move.getId());
            moveDTO.setCurrentPlayer(PlayerDtoBuilder.builder()
                    .id(move.getCurrentPlayer().getPlayerId())
                    .createdAt(move.getCurrentPlayer().getCreatedAt())
                    .active(move.getCurrentPlayer().getActive())
                    .email(move.getCurrentPlayer().getEmail())
                    .nickName(move.getCurrentPlayer().getNickName())
                    .status(move.getCurrentPlayer().getStatus())
                    .updatedAt(move.getCurrentPlayer().getUpdatedAt())
                    .build());
            moveDTO.setValues(move.getValuesPlayed());
            this.match.getMoveList().add(moveDTO);
        }
        return this;
    }

    public MatchDTO build() {
        return this.match;
    }

    private PlayerDto createPlayerDto(Player playerTwo) {
        PlayerDto playerDto = PlayerDtoBuilder.builder()
                .id(playerTwo.getPlayerId())
                .createdAt(playerTwo.getCreatedAt())
                .active(playerTwo.getActive())
                .email(playerTwo.getEmail())
                .nickName(playerTwo.getNickName())
                .status(playerTwo.getStatus())
                .updatedAt(playerTwo.getUpdatedAt())
                .build();
        return playerDto;
    }

}
