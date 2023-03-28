package com.br.uni.edu.jogoDaVelha.resource;

import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.response.Response;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerResource {

    private final PlayerService playerService;

    public PlayerResource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Response<Player> savePlayer(@RequestBody Player player){
        Response<Player> response = new Response<>();
        try{
            Player playersaved = playerService.savePlayer(player);
            response.setData(playersaved);
            response.setStatusCode(HttpStatus.CREATED.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return response;

    }

    @DeleteMapping
    public Response<Player> deletePLayer(@RequestBody Long uuid){
        Response<Player> response = new Response<>();
        try{
            playerService.deletePlayer(uuid);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return response;

    }


    @PutMapping("/{id}")
    public Response<Player> update(@PathVariable Long id, @RequestBody Player player){
        Response<Player> response = new Response<>();
        try{
            Player playerUpdt = playerService.updatePlayer(id, player);
            response.setData(playerUpdt);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return response;

    }


    @GetMapping("/{id}")
    public Response<Player> findById(@PathVariable Long id){
        Response<Player> response = new Response<>();
        try{
            Player player = playerService.findById(id);
            response.setData(player);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return response;

    }


    @GetMapping
    public Response<List<Player>> findAll(){
        Response<List<Player>> response = new Response<>();
        try{
            List<Player> players = playerService.findAll();
            response.setData(players);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return response;

    }
}
