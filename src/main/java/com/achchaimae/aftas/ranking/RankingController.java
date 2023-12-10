package com.achchaimae.aftas.ranking;

import com.achchaimae.aftas.hunting.DTO.HuntingRespDTO;
import com.achchaimae.aftas.ranking.DTO.RankingRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ranking")
public class RankingController {
    @Autowired
    RankingService rankingService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RankingRespDTO>> getMembers(){
        return ResponseEntity.ok().body(rankingService.getRankings());
    }


}
