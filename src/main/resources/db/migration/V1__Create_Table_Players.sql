create table tb_players (
 player_id bigint AUTO_INCREMENT NOT NULL,
 active int,
 created_at timestamp(6),
 deleted_at timestamp(6),
 email varchar(255),
 nick_name varchar(255),
 password varchar(255),
 status ENUM('ACTIVE', 'INACTIVE', 'BLOCK') NOT NULL,
 updated_at timestamp(6),
 primary key (player_id)
 );