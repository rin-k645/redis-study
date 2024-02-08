package com.rin.redisranking.repository.jpa;

import com.rin.redisranking.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamJPARepository extends JpaRepository<Team, Integer> {
    List<Team> findAllByTeamIdIn(List<Integer> teamIdList);
}
