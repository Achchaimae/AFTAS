package com.achchaimae.aftas.ranking;

import com.achchaimae.aftas.ranking.dto.RankingIDReq;
import com.achchaimae.aftas.ranking.dto.RankingReqDTO;
import com.achchaimae.aftas.ranking.dto.RankingRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<RankingRespDTO> save(@RequestBody RankingReqDTO ranking)
    {
        RankingRespDTO ranking1 = rankingService.saveRanking(ranking);
        return ResponseEntity.ok().body(ranking1);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<RankingRespDTO> getRankingById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(rankingService.findRanking(id));
    }
    @GetMapping("findByCompOrder/{searchterm}")
    public ResponseEntity<List<RankingRespDTO>> getRankCompOrder(@PathVariable String searchterm)
    {
        return ResponseEntity.ok().body(rankingService.findByCompOrder(searchterm));
    }
    @GetMapping("findByComp/{searchterm}")
    public ResponseEntity<List<RankingRespDTO>> getRankComp(@PathVariable String searchterm)
    {
        return ResponseEntity.ok().body(rankingService.findByComp(searchterm));
    }

    @GetMapping("/poduim/{code}")
    public ResponseEntity<List<RankingRespDTO>> getPodium(@PathVariable String code)
    {
        return ResponseEntity.ok().body(rankingService.calculateAndFetchRankings(code));
    }

    @DeleteMapping("/{competition_code}/{member_id}")
    public void delete(@PathVariable String competition_code,@PathVariable Integer member_id) {
        RankingIDReq rankingIdReqDTO = new RankingIDReq();
        rankingIdReqDTO.setMember_id(member_id);
        rankingIdReqDTO.setCompetition_id(competition_code);
        Integer deleted = rankingService.Delete(rankingIdReqDTO);
    }


}
