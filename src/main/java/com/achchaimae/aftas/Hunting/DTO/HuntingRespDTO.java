package com.achchaimae.aftas.Hunting.DTO;

import com.achchaimae.aftas.Competition.Competition;
import com.achchaimae.aftas.Competition.DTO.CompetitionReqDTO;
import com.achchaimae.aftas.Fish.DTO.FishReqDTO;
import com.achchaimae.aftas.Fish.Fish;
import com.achchaimae.aftas.Member.DTO.MemberReqDTO;
import com.achchaimae.aftas.Member.Member;
import lombok.Data;

@Data
public class HuntingRespDTO {
    private Integer id;
    private Integer numberOfFish;
    private FishReqDTO fish;
    private MemberReqDTO member;
    private CompetitionReqDTO competition;

}
