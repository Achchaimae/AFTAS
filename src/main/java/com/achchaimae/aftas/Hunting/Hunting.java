package com.achchaimae.aftas.Hunting;


import com.achchaimae.aftas.Competition.Competition;
import com.achchaimae.aftas.Fish.Fish;
import com.achchaimae.aftas.Level.Level;
import com.achchaimae.aftas.Member.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
