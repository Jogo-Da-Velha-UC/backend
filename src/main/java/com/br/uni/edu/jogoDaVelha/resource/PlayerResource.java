package com.br.uni.edu.jogoDaVelha.resource;

import com.br.uni.edu.jogoDaVelha.dtos.PlayerDto;
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
    public ResponseEntity<Response<PlayerDto>> savePlayer(@RequestBody CreatePlayerRequest playerRequest){
        Response<PlayerDto> response = new Response<>();
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
    public ResponseEntity<Response<PlayerDto>> deletePLayer(@RequestBody Long uuid){
        Response<PlayerDto> response = new Response<>();
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
    public ResponseEntity<Response<PlayerDto>> update(@PathVariable Long id, @RequestBody Player player){
        Response<PlayerDto> response = new Response<>();
        try{
            response.setData(playerService.updatePlayer(id, player));
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<PlayerDto>> findById(@PathVariable Long id){
        Response<PlayerDto> response = new Response<>();
        try{

            response.setData(playerService.findById(id));
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }


    @GetMapping
    public ResponseEntity<Response<List<PlayerDto>>> findAll(){
        Response<List<PlayerDto>> response = new Response<>();
        try{
            response.setData(playerService.findAll());
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }
}
