package com.achchaimae.aftas.ranking.DTO;

import com.achchaimae.aftas.ranking.RankingID;
import lombok.Data;

@Data
public class RankingRespDTO {
    private RankingID id;
    private int rank;
    private int score;
}
