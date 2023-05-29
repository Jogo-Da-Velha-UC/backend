CREATE TABLE tb_moves (
  id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  match_id bigint NOT NULL,
  values_played JSON NOT NULL,
  current_player bigint NOT NULL,
  created_at date NOT NULL,
  updated_at date NOT NULL,
  deleted_at date NULL
);

ALTER TABLE tb_moves ADD CONSTRAINT fk_current_player FOREIGN KEY (current_player) REFERENCES tb_players (player_id);