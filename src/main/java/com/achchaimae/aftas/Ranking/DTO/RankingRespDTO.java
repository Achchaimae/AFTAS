package com.achchaimae.aftas.Ranking.DTO;

import com.achchaimae.aftas.Ranking.RankingID;
import lombok.Data;

@Data
public class RankingRespDTO {
    private RankingID id;
    private int rank;
    private int score;
}
