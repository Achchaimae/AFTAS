package com.achchaimae.aftas.Ranking;

import com.achchaimae.aftas.Competition.Competition;
import com.achchaimae.aftas.Level.Level;
import com.achchaimae.aftas.Member.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class RankingID implements Serializable {

    @ManyToOne
    @JoinColumn(name = "competition_code")
    private Competition competition;

    @ManyToOne
    @JoinColumn(name = "member_code")
    private Member member;
}
