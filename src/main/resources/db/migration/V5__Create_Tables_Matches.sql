create table tb_matches (
 id_match bigint AUTO_INCREMENT NOT NULL,
 created_at timestamp(6),
 deleted_at timestamp(6),
 updated_at timestamp(6),
 game_struct_game_struct_id bigint,
 player_one_player_id bigint,
 player_two_player_id bigint,
 started_with_player_id bigint,
 status_match_status_match_id bigint,
 primary key (id_match)
 );