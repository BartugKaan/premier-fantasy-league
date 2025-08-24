package com.pl.premier_zone.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
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

    public List<Player> getPlayersByPosition(String position){
        return  _playerRepository
                .findAll()
                .stream()
                .filter(p -> p.getTeam()
                        .toLowerCase()
                        .contains(position.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNation(String nation){
        return _playerRepository
                .findAll()
                .stream()
                .filter(p -> p.getNation()
                        .toLowerCase()
                        .contains(nation.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return _playerRepository
                .findAll()
                .stream()
                .filter(p -> team.equals(p.getTeam()) && position.equals(p.getPos()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        _playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = _playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setNation(updatedPlayer.getNation());
            _playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    public void deletePlayer(String playerName){
        _playerRepository.deleteByName(playerName);
    }
}
