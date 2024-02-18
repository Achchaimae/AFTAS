package com.achchaimae.aftas.ranking.dto;

import com.achchaimae.aftas.competition.dto.CompetitionReqDTO;
import com.achchaimae.aftas.member.dto.MemberRespDTO;
import lombok.Data;

@Data
public class RankingIDResp {

    private MemberRespDTO member;
    private CompetitionReqDTO competition;
}
