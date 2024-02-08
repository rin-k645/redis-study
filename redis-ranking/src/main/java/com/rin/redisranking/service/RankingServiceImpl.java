package com.rin.redisranking.service;

import com.rin.redisranking.entity.Team;
import com.rin.redisranking.repository.jpa.TeamJPARepository;
import com.rin.redisranking.repository.redis.RankingRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RankingServiceImpl implements RankingService {
    @Autowired
    private RankingRedisRepository rankingRedisRepository;
    @Autowired
    private TeamJPARepository teamJPARepository;

    @Override
    public List<Team> viewRanking(String sports, String gameType, String sort) {
        List<Integer> teamIdList = rankingRedisRepository.getTeamRanking(sports, gameType, sort);
        List<Team> teamList = teamJPARepository.findAllByTeamIdIn(teamIdList);
        return teamList;
    }
}
