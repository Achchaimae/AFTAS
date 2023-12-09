package com.achchaimae.aftas.ranking;

import com.achchaimae.aftas.competition.Competition;
import com.achchaimae.aftas.member.Member;
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
