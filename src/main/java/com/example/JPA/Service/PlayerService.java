package com.example.JPA.Service;


import com.example.JPA.Controller.PlayerController;
import com.example.JPA.DAO.PlayerRepository;
import com.example.JPA.Model.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;


    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        System.out.println("----------Player Repository hit in player service-------------");
        this.playerRepository = playerRepository;
    }

    public List<PlayerModel> getPlayers(){
        return playerRepository.findAll();
    }


    public void addPlayer(PlayerModel playerModel) {
        System.out.println(playerModel);

        Optional<PlayerModel> playerByName = playerRepository.findPlayerModelByName(playerModel.getName());

        if(playerByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
        playerRepository.save(playerModel);

    }

    public void deletePlayer(Integer id) {

        Optional<PlayerModel> player = playerRepository.findById(id);

        boolean playerExists = player.isPresent();

        if(!playerExists){
            throw new IllegalStateException("player does not exist");
        }


        playerRepository.deleteById(id);
        System.out.println("Player with the following details deleted"+player);
    }

    public void updatePlayer(String name ,Integer titles , String nationanlity){

        Optional<PlayerModel> player = playerRepository.findPlayerModelByName(name);
        boolean playerExists = player.isPresent();
        if(!playerExists){
            throw new IllegalStateException("the player does not exist");
        }

        if(nationanlity!=null){
            player.get().setNationality(nationanlity);
            System.out.println("Existing titles for the player"+player.get().getTitles());

            player.get().setTitles(titles);

            playerRepository.save(player.get());

        }




    }

}
