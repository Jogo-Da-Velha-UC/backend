CREATE TABLE tb_players (
  player_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  nick_name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL,
  password VARCHAR(50) NOT NULL,
  created_at date NOT NULL,
  updated_at date NOT NULL,
  deleted_at date NULL,
  active int NOT NULL,
  status ENUM('ACTIVE', 'INACTIVE', 'BLOCK') NOT NULL
);