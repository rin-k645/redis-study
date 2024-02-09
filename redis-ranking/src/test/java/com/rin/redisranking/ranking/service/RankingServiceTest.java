package com.rin.redisranking.ranking.service;

import com.rin.redisranking.entity.Team;
import com.rin.redisranking.service.RankingService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RankingServiceTest {
    @Autowired
    RankingService rankingService;

    @Test
    @DisplayName("viewRanking")
    void test1() {
        String sports = "농구";
        String gameType = "3vs3";
        String sortType = "rating";

        List<Team> teamList = rankingService.viewRanking(sports, gameType, sortType);

        for(Team team : teamList) {
            System.out.println(team.getTeamId());
        }

        Assertions.assertThat(teamList.size()).isEqualTo(10);
    }
}
