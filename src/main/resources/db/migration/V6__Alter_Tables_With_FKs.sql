alter table  tb_matches add constraint FK6b1b4ute4488uc3nwjgtsyy02 foreign key (game_struct_game_struct_id) references tb_game_structs (game_struct_id);
alter table  tb_matches add constraint FKidcvier05wsckl6bq7ix6kg29 foreign key (player_one_player_id) references tb_players (player_id);
alter table  tb_matches add constraint FK3o4yg1fysyu62mbxx6k84k8u foreign key (player_two_player_id) references tb_players (player_id);
alter table  tb_matches add constraint FKixhj42fs6r7sw08o2fb835tkv foreign key (started_with_player_id) references tb_players (player_id);
alter table  tb_matches add constraint FKfbn3mlm3v3i0ykyow2y4i9wgq foreign key (status_match_status_match_id) references tb_status_matches (status_match_id);
alter table  tb_moves add constraint FKi6pvvkps3xjbnpcc331if8otf foreign key (current_player_player_id) references tb_players (player_id);
alter table  tb_moves add constraint FK7m0aiuh0py8oq7wb5pn79yvkv foreign key (match_id) references tb_matches (id_match);
alter table  tb_status_matches add constraint FKki8pekmm3rnjenqh5xx2cqa37 foreign key (winner_player_id) references tb_players (player_id);