package com.achchaimae.aftas.hunting;


import com.achchaimae.aftas.competition.Competition;
import com.achchaimae.aftas.fish.Fish;
import com.achchaimae.aftas.member.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Hunting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfFish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fish_name")
    private Fish fish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_code")
    private Competition competition;
}
