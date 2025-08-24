package com.pl.premier_zone.player;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public Page<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation,
            @ParameterObject
            @PageableDefault(size = 20, sort = "playerName", direction = Sort.Direction.ASC)
            Pageable pageable

    ){
        return  playerService.getPlayers(team, name, position, nation, pageable);
    }

    @GetMapping("/all")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayer();
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        if(player == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Player createdPlayer = playerService.addPlayer(player);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player resultPlayer = playerService.updatePlayer(player);
        if(resultPlayer != null){
            return  ResponseEntity.status(HttpStatus.OK).body(resultPlayer);
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        if(playerName == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player Deleted Successfully",HttpStatus.OK);

    }
}
