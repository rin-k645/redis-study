package com.rin.redisranking.ranking.redisRepository;

import com.rin.redisranking.repository.redis.RankingRedisRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RankingRedisRepositoryTest {
    @Autowired
    private RankingRedisRepository redisRepository;

    @Test
    @DisplayName("saveRanking")
    void test1() {
        String sports = "농구";
        String gameType = "3vs3";
        String sortType = "rating";

        redisRepository.save(sports, gameType, sortType, 1, 130);
        redisRepository.save(sports, gameType, sortType, 2, 150);
        redisRepository.save(sports, gameType, sortType, 3, 110);
    }

    @Test
    @DisplayName("getTop10Ranking")
    void test2() {
        String sports = "농구";
        String gameType = "3vs3";
        String sortType = "rating";

        List<Integer> teamIdList = redisRepository.getTeamRanking(sports, gameType, sortType);

        for(int id : teamIdList) {
            System.out.println(id);
        }
    }
}
