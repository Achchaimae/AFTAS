package com.achchaimae.aftas.ranking;

import com.achchaimae.aftas.ranking.DTO.RankingReqDTO;
import com.achchaimae.aftas.ranking.DTO.RankingRespDTO;
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

//    @PutMapping("/{competitionCode}")
//    public ResponseEntity<RankingRespDTO> update(@PathVariable Integer id, @RequestBody RankingReqDTO ranking)
//    {
//        return ResponseEntity.ok().body(rankingService.updateRankings(ranking,id);
//    }
//    public void updateRankingsForCompetition(@RequestBody String competitionCode) {
//        rankingService.updateRankingsForCompetition(competitionCode);
//    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RankingRespDTO> getRankingById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(rankingService.findRanking(id));
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
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id)
    {
        Integer deleted = rankingService.DeleteHunting(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("ranking deleted");
        }
        return ResponseEntity.badRequest().body("ranking not deleted");
    }

}
