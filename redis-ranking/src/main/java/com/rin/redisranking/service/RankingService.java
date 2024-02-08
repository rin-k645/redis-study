package com.rin.redisranking.service;

import com.rin.redisranking.entity.Team;

import java.util.List;

public interface RankingService {
    List<Team> viewRanking(String sports, String gameType, String sort);
}
