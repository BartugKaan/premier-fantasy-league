package com.pl.premier_zone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, String>, JpaSpecificationExecutor<Player> {

    void deleteByPlayerName(String playerName);
    Optional<Player> findByPlayerName(String playerName);

}
