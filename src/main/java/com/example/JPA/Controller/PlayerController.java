package com.example.JPA.Controller;


import com.example.JPA.Model.PlayerModel;
import com.example.JPA.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/player")
public class PlayerController {

    PlayerService playerService;

    @Autowired
    PlayerController(PlayerService playerService){
        this.playerService=playerService;
    }

    @GetMapping
    public List<PlayerModel> getPlayers(){
        return playerService.getPlayers();
    }

    @PostMapping(path="/post")
    public void addPlayer(@RequestBody PlayerModel playerModel){
        playerService.addPlayer(playerModel);
    }

    @DeleteMapping(path="/delete/{playerId}")
    public void deletePlayer(@PathVariable("playerId") Integer id){
        playerService.deletePlayer(id);
    }

    @PutMapping(path="update/{playerName}/{title}")
    public void updatePlayer(@PathVariable("playerName") String name ,
                             @PathVariable("title") Integer titles,
                             @RequestParam(required = false) String nationality
    ){
        playerService.updatePlayer(name,titles,nationality);



    }

}
