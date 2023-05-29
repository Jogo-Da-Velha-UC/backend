CREATE TABLE tb_matches (
  id_match bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  player_one_id bigint NULL,
  player_two_id bigint NULL,
  game_struct bigint NOT NULL,
  status_match_id bigint NOT NULL,
  started_with_player_id bigint NULL,
  created_at date NOT NULL,
  updated_at date NOT NULL,
  deleted_at date NULL
);

ALTER TABLE tb_matches ADD CONSTRAINT fk_player_one_id FOREIGN KEY (player_one_id) REFERENCES tb_players (player_id);
ALTER TABLE tb_matches ADD CONSTRAINT fk_player_two_id FOREIGN KEY (player_two_id) REFERENCES tb_players (player_id);
ALTER TABLE tb_matches  ADD CONSTRAINT fk_game_struct FOREIGN KEY (game_struct) REFERENCES tb_game_structs (game_struct_id);
ALTER TABLE tb_matches  ADD CONSTRAINT fk_status_match_id FOREIGN KEY (status_match_id) REFERENCES tb_status_matches (status_match_id);
ALTER TABLE tb_matches ADD CONSTRAINT fk_started_with_player_id FOREIGN KEY (started_with_player_id) REFERENCES tb_players (player_id);
ALTER TABLE tb_moves ADD CONSTRAINT fk_match_id FOREIGN KEY (match_id) REFERENCES tb_matches (id_match);