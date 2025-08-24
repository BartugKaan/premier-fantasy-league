package com.pl.premier_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class PlayerService {
    private  final IPlayerRepository _playerRepository;

    @Autowired
    public PlayerService(IPlayerRepository playerRepository) {
        this._playerRepository = playerRepository;
    }

    public Page<Player> getPlayers(String team, String name, String position, String nation, Pageable pageable) {
        Specification<Player> spec = Specification.<Player>unrestricted()
                .and(PlayerSpecifications.hasTeam(team))
                .and(PlayerSpecifications.hasNameLike(name))
                .and(PlayerSpecifications.hasPosition(position))
                .and(PlayerSpecifications.hasNation(nation));

        return _playerRepository.findAll(spec, pageable);
    }

    public Player addPlayer(Player player){
        _playerRepository.save(player);
        return player;
    }

    public List<Player> getAllPlayer(){
        return _playerRepository.findAll();
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = _playerRepository.findByPlayerName(updatedPlayer.getPlayerName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setPlayerName(updatedPlayer.getPlayerName());
            playerToUpdate.setTeamName(updatedPlayer.getTeamName());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setNation(updatedPlayer.getNation());
            _playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName){
        Optional<Player> player = _playerRepository.findByPlayerName(playerName);

        player.ifPresent(_playerRepository::delete);
    }
}
