create table tb_status_matches (
 status_match_id bigint AUTO_INCREMENT NOT NULL,
 created_at timestamp(6),
 deleted_at timestamp(6),
 status_match_enum ENUM('ACTIVE', 'FINISHED', 'DRAW', 'WAITING_FOR_PLAYER') NOT NULL,
 updated_at timestamp(6),
 winner_player_id bigint,
 primary key (status_match_id)
 );