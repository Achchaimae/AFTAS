package com.achchaimae.aftas.ranking;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Ranking {
    @EmbeddedId
    private RankingID id;
    private int rank;
    private int score;
}
