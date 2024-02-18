package com.achchaimae.aftas.hunting.dto;

import com.achchaimae.aftas.competition.dto.CompetitionReqDTO;
import com.achchaimae.aftas.fish.dto.FishReqDTO;
import com.achchaimae.aftas.member.dto.MemberReqDTO;
import lombok.Data;

@Data
public class HuntingRespDTO {
    private Integer id;
    private Integer numberOfFish;
    private FishReqDTO fish;
    private MemberReqDTO member;
    private CompetitionReqDTO competition;

}
