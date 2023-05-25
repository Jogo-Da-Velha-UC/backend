package com.br.uni.edu.jogoDaVelha.repositories;

import com.br.uni.edu.jogoDaVelha.model.GameStruct;
import com.br.uni.edu.jogoDaVelha.model.StatusMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusMatchRepository extends JpaRepository<StatusMatch, Long> {
}
