CREATE TABLE tb_status_matches (
  status_match_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  winner bigint NULL,
  status_match_enum ENUM('ACTIVE', 'FINISHED', 'DRAW', 'WAITING_FOR_PLAYER') NOT NULL,
  created_at date NOT NULL,
  updated_at date NOT NULL,
  deleted_at date NULL
);

ALTER TABLE tb_status_matches ADD CONSTRAINT fk_winner_id FOREIGN KEY (winner) REFERENCES tb_players (player_id);