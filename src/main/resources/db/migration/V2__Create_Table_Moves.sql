create table tb_moves (
 id bigint AUTO_INCREMENT NOT NULL,
 created_at timestamp(6),
 deleted_at timestamp(6),
 updated_at timestamp(6),
 values_played JSON,
 current_player_player_id bigint,
 match_id bigint, primary key (id)
 );