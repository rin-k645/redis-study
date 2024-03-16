package com.rin.redisranking.repository.jpa;

import com.rin.redisranking.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamJPARepository extends JpaRepository<Team, Integer> {
    List<Team> findAllByTeamIdIn(List<Integer> teamIdList);
    Team save(Team team);

    List<Team> getTop10BySportsAndGameTypeOrderByMatchTimesDesc(String sports, String gameType);
    List<Team> getTop10BySportsAndGameTypeOrderByWinDesc(String sports, String gameType);
    List<Team> getTop10BySportsAndGameTypeOrderByDrawDesc(String sports, String gameType);
    List<Team> getTop10BySportsAndGameTypeOrderByLoseDesc(String sports, String gameType);
    List<Team> getTop10BySportsAndGameTypeOrderByPointDesc(String sports, String gameType);
}