package com.rin.redisranking.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    private String name;
    private String sports;
    private String gameType;
    private String level;
    private int point;
    private String tier;
    private int matchTimes;
    private int win;
    private int draw;
    private int lose;


    public Team(String name, String sports, String gameType, String level, int point, String tier, int matchTimes, int win, int draw, int lose) {
        this.name = name;
        this.sports = sports;
        this.gameType = gameType;
        this.level = level;
        this.point = point;
        this.tier = tier;
        this.matchTimes = matchTimes;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
    }
}
