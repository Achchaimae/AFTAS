package com.achchaimae.aftas.ranking;

import com.achchaimae.aftas.ranking.DTO.RankingReqDTO;
import com.achchaimae.aftas.ranking.DTO.RankingRespDTO;

import java.util.List;

public interface RankingServiceInterface {

    List<RankingRespDTO> getRankings();
    RankingRespDTO saveRanking(RankingReqDTO ranking);
//    RankingRespDTO updateRanking(RankingReqDTO ranking, Integer id);
    Integer DeleteHunting(Integer rankingId);
    RankingRespDTO findRanking(Integer rankingId);
}
