package com.rin.redisranking.repository.redis;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RankingRedisRepository {
    @Autowired
    private RedisTemplate redisTemplate;
    private ZSetOperations<String, String> zSetOperations ;

    private final int START = 0;
    private final int END = 10;

    @PostConstruct
    private void init() {
        zSetOperations = redisTemplate.opsForZSet();
    }

    public void save(String sports, String gameType, String sortType, int teamId, int score) {
        String key = sports + gameType + sortType;
        zSetOperations.add(key, Integer.toString(teamId), score);
    }

    public List<Integer> getTeamRanking(String sports, String gameType, String sortType) {
        String key = sports + gameType + sortType;
        Set<String> idSet = zSetOperations.reverseRange(key, START, END); //key가 없어도 사이즈 0인 상태로 반환

        return idSet.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
