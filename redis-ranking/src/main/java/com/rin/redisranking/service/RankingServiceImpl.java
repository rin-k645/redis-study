package com.rin.redisranking.service;

import com.rin.redisranking.entity.Team;
import com.rin.redisranking.repository.jpa.TeamJPARepository;
import com.rin.redisranking.repository.redis.RankingRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
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
        sortBySortType(sort, teamList);
        return teamList;
    }

    private void sortBySortType(String sort, List<Team> teamList) {
        switch (sort) {
            case "times" : teamList.sort(Comparator.comparing(Team::getMatchTimes).reversed()); break;
            case "win" : teamList.sort(Comparator.comparing(Team::getWin).reversed()); break;
            case "draw" : teamList.sort(Comparator.comparing(Team::getDraw).reversed()); break;
            case "lose" : teamList.sort(Comparator.comparing(Team::getLose).reversed()); break;
            case "rating" : teamList.sort(Comparator.comparing(Team::getPoint).reversed()); break;
        }
    }
}
