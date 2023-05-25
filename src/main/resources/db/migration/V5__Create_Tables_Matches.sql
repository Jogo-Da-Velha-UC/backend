CREATE TABLE tb_matches (
  id_match bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  player_one bigint NULL,
  player_two bigint NULL,
  game_struct bigint NULL,
  status_match bigint NULL,
  started_with bigint NULL,
  created_at date NOT NULL,
  updated_at date NOT NULL,
  deleted_at date NULL
);

ALTER TABLE tb_matches
  ADD CONSTRAINT fk_player_one FOREIGN KEY (player_one) REFERENCES tb_players (player_id),
  ADD CONSTRAINT fk_player_two FOREIGN KEY (player_two) REFERENCES tb_players (player_id),
  ADD CONSTRAINT fk_game_struct FOREIGN KEY (game_struct) REFERENCES tb_game_structs (game_struct_id),
  ADD CONSTRAINT fk_status_match FOREIGN KEY (status_match) REFERENCES tb_status_matches (status_match_id),
  ADD CONSTRAINT fk_started_with FOREIGN KEY (started_with) REFERENCES tb_players (player_id);

ALTER TABLE tb_moves ADD CONSTRAINT fk_match_id FOREIGN KEY (match_id) REFERENCES tb_matches (id_match);