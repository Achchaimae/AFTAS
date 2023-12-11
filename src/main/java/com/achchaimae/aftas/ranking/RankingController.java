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

    @PutMapping("/{id}")
    public ResponseEntity<RankingRespDTO> update(@PathVariable Integer id, @RequestBody RankingReqDTO ranking)
    {
        return ResponseEntity.ok().body(rankingService.updateRanking(ranking,id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RankingRespDTO> getRankingById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(rankingService.findRanking(id));
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
