package com.pl.premier_zone.player;

import org.springframework.data.jpa.domain.Specification;

public class PlayerSpecifications {

    private  PlayerSpecifications() {
    }

    public static Specification<Player> hasTeam(String team){
        return (root, q, cb) ->
                (team == null || team.isBlank())
                ? cb.conjunction()
                        : cb.equal(cb.lower(root.get("team")), team.toLowerCase());
    }

    public static Specification<Player> hasNameLike(String name){
        return (root, q, cb) ->
                (name == null || name.isBlank())
                        ? cb.conjunction()
                        : cb.equal(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Player> hasPosition(String position){
        return (root, q, cb) ->
                (position == null || position.isBlank())
                        ? cb.conjunction()
                        : cb.equal(cb.lower(root.get("position")), position.toLowerCase());
    }

    public static Specification<Player> hasNation(String nation){
        return (root, q, cb) ->
                (nation == null || nation.isBlank())
                        ? cb.conjunction()
                        : cb.equal(cb.lower(root.get("nation")), nation.toLowerCase());
    }
}
