CREATE TABLE tb_game_structs (
  game_struct_id bigint AUTO_INCREMENT NOT NULL PRIMARY KEY,
  fields JSON NULL,
  created_at date NOT NULL,
  updated_at date NOT NULL,
  deleted_at date NULL
);