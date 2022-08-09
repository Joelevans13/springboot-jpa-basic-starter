package com.example.JPA.DAO;

import com.example.JPA.Model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlayerRepository extends JpaRepository<PlayerModel, Integer> {


    Optional<PlayerModel> findPlayerModelByName(String playerName);


}
