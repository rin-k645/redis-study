package com.rin.redisranking.service;

import com.rin.redisranking.entity.Team;

import java.util.List;

public interface RankingService {
    List<Team> viewRanking(String sports, String gameType, String sort);
    List<Team> viewRanking2(String sports, String gameType, String sort);
}
