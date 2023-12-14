package com.achchaimae.aftas.ranking.DTO;

import com.achchaimae.aftas.competition.DTO.CompetitionReqDTO;
import com.achchaimae.aftas.member.DTO.MemberRespDTO;
import lombok.Data;

@Data
public class RankingIDResp {

    private MemberRespDTO member;
    private CompetitionReqDTO competition;
}
