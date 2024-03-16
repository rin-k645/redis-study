package com.rin.redisranking.ranking.redisRepository;

import com.rin.redisranking.entity.Team;
import com.rin.redisranking.repository.jpa.TeamJPARepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RankingJPARepositoryTest {

    @Autowired
    private TeamJPARepository teamJPARepository;

    @Test
    @DisplayName("saveRanking")
    void test_insertTeam() {
        for(int i = 1; i <= 100000; i++) {
            Team team = new Team("팀이름", "축구", "5vs5", "1", i, "1", i, i, i, i);
            teamJPARepository.save(team);
        }
    }

    @Test
    @DisplayName("viewRanking")
    void test1() {
        String sports = "농구";
        String gameType = "3vs3";
        String sortType = "rating";

        List<Team> teamList = teamJPARepository.getTop10BySportsAndGameTypeOrderByPointDesc(sports, gameType);

        Assertions.assertThat(teamList.size()).isEqualTo(10);
    }
}
