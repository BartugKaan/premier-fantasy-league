package com.pl.premier_zone.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private  final IPlayerRepository _playerRepository;

    @Autowired
    public PlayerService(IPlayerRepository playerRepository) {
        this._playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return _playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName){
        return  _playerRepository
                .findAll()
                .stream()
                .filter(p -> teamName.equals(p.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersFromName(String searchText){
        return  _playerRepository
                .findAll()
                .stream()
                .filter(p -> p.getName()
                        .toLowerCase()
                        .contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }




}
