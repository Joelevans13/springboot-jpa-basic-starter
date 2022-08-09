package com.example.JPA.DBpersistTest;


import com.example.JPA.DAO.PlayerRepository;
import com.example.JPA.Model.PlayerModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Configuration
public class PlayerConfiguration {


    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository){
        return args -> {
            PlayerModel player1 = new PlayerModel(
                    "player4",
                    "indian",
                    LocalDate.of(1999, Month.JANUARY,13),
                    2
                    );
            PlayerModel player2 = new PlayerModel(
                    "Player5",
                    "Indian",
                    LocalDate.of(1997, Month.JANUARY,13),
                    2
            );

            playerRepository.saveAll(List.of(player1,player2));

            System.out.println(player2.getAge());


        };

    }
}
