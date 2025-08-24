package com.pl.premier_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_statistic")
public class Player {

    @Id
    @Column(name = "player_name", unique = true, nullable = false, length = 100)
    private String playerName;

    @Column(name = "nation", length = 50)
    private String nation;

    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "age")
    private Integer age;

    @Column(name = "matches_played")
    private Integer matchesPlayed;

    @Column(name = "starts")
    private Integer starts;

    @Column(name = "minutes_played")
    private Double minutesPlayed;

    @Column(name = "goals")
    private Double goals;

    @Column(name = "assists")
    private Double assists;

    @Column(name = "penalties_scored")
    private Double penaltiesScored;

    @Column(name = "yellow_cards")
    private Double yellowCards;

    @Column(name = "red_cards")
    private Double redCards;

    @Column(name = "expected_goals")
    private Double expectedGoals;

    @Column(name = "expected_assists")
    private Double expectedAssists;

    @Column(name = "team_name", length = 100)
    private String teamName;

    public Player() {}

    public Player(String playerName, String nation, String position, Integer age,
                  Integer matchesPlayed, Integer starts, Double minutesPlayed,
                  Double goals, Double assists, Double penaltiesScored,
                  Double yellowCards, Double redCards, Double expectedGoals,
                  Double expectedAssists, String teamName) {
        this.playerName = playerName;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.matchesPlayed = matchesPlayed;
        this.starts = starts;
        this.minutesPlayed = minutesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.penaltiesScored = penaltiesScored;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.expectedGoals = expectedGoals;
        this.expectedAssists = expectedAssists;
        this.teamName = teamName;
    }

    // Getters & Setters
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public String getNation() { return nation; }
    public void setNation(String nation) { this.nation = nation; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(Integer matchesPlayed) { this.matchesPlayed = matchesPlayed; }

    public Integer getStarts() { return starts; }
    public void setStarts(Integer starts) { this.starts = starts; }

    public Double getMinutesPlayed() { return minutesPlayed; }
    public void setMinutesPlayed(Double minutesPlayed) { this.minutesPlayed = minutesPlayed; }

    public Double getGoals() { return goals; }
    public void setGoals(Double goals) { this.goals = goals; }

    public Double getAssists() { return assists; }
    public void setAssists(Double assists) { this.assists = assists; }

    public Double getPenaltiesScored() { return penaltiesScored; }
    public void setPenaltiesScored(Double penaltiesScored) { this.penaltiesScored = penaltiesScored; }

    public Double getYellowCards() { return yellowCards; }
    public void setYellowCards(Double yellowCards) { this.yellowCards = yellowCards; }

    public Double getRedCards() { return redCards; }
    public void setRedCards(Double redCards) { this.redCards = redCards; }

    public Double getExpectedGoals() { return expectedGoals; }
    public void setExpectedGoals(Double expectedGoals) { this.expectedGoals = expectedGoals; }

    public Double getExpectedAssists() { return expectedAssists; }
    public void setExpectedAssists(Double expectedAssists) { this.expectedAssists = expectedAssists; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
}
