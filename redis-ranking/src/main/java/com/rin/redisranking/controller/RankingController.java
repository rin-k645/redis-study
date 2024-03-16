package com.rin.redisranking.controller;

import com.rin.redisranking.entity.Team;
import com.rin.redisranking.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;
    @GetMapping("/view1")
    public ResponseEntity<?> list(String sports, String gameType, String sort) {
        try {
            List<Team> list = rankingService.viewRanking(sports, gameType, sort);
            if (list != null && !list.isEmpty()) {
                return new ResponseEntity<List<Team>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/view2")
    public ResponseEntity<?> list2(String sports, String gameType, String sort) {
        try {
            List<Team> list = rankingService.viewRanking2(sports, gameType, sort);
            if (list != null && !list.isEmpty()) {
                return new ResponseEntity<List<Team>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<?> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
