create table tb_game_structs (
 game_struct_id bigint AUTO_INCREMENT NOT NULL,
 created_at timestamp(6),
 deleted_at timestamp(6),
 fields JSON NOT NULL,
 updated_at timestamp(6),
 primary key (game_struct_id)
 );