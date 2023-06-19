package com.br.uni.edu.jogoDaVelha.repositories;

import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "SELECT match FROM Match match WHERE match.playerOne.nickName = :playerOne AND match.playerTwo.nickName = :playerTwo AND match.statusMatch.statusMatchEnum = ACTIVE")
    Match findMatchWithOneOnlyPlayer(String playerOne, String playerTwo);

    @Query(value = "SELECT match FROM Match match WHERE match.playerOne.playerId = :id OR match.playerTwo.playerId = :id")
    Optional<List<Match>> findMatchesByUser(@Param("id") Long id);
}
