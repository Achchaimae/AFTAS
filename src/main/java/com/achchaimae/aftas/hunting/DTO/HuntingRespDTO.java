package com.achchaimae.aftas.hunting.DTO;

import com.achchaimae.aftas.competition.DTO.CompetitionReqDTO;
import com.achchaimae.aftas.fish.DTO.FishReqDTO;
import com.achchaimae.aftas.member.DTO.MemberReqDTO;
import lombok.Data;

@Data
public class HuntingRespDTO {
    private Integer id;
    private Integer numberOfFish;
    private FishReqDTO fish;
    private MemberReqDTO member;
    private CompetitionReqDTO competition;

}
