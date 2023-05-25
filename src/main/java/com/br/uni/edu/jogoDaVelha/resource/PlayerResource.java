package com.br.uni.edu.jogoDaVelha.resource;

import com.br.uni.edu.jogoDaVelha.model.Player;
import com.br.uni.edu.jogoDaVelha.dtos.Response;
import com.br.uni.edu.jogoDaVelha.requests.CreatePlayerRequest;
import com.br.uni.edu.jogoDaVelha.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerResource {

    private final PlayerService playerService;

    public PlayerResource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Response<Player>> savePlayer(@RequestBody CreatePlayerRequest playerRequest){
        Response<Player> response = new Response<>();
        try{
            response.setData(playerService.savePlayer(playerRequest));
            response.setStatusCode(HttpStatus.CREATED.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping
    public ResponseEntity<Response<Player>> deletePLayer(@RequestBody Long uuid){
        Response<Player> response = new Response<>();
        try{
            playerService.deletePlayer(uuid);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Response<Player>> update(@PathVariable Long id, @RequestBody Player player){
        Response<Player> response = new Response<>();
        try{
            Player playerUpdt = playerService.updatePlayer(id, player);
            response.setData(playerUpdt);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<Player>> findById(@PathVariable Long id){
        Response<Player> response = new Response<>();
        try{
            Player player = playerService.findById(id);
            response.setData(player);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }


    @GetMapping
    public ResponseEntity<Response<List<Player>>> findAll(){
        Response<List<Player>> response = new Response<>();
        try{
            List<Player> players = playerService.findAll();
            response.setData(players);
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }
}
