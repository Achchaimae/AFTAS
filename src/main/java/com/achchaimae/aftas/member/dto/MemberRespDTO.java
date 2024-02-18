package com.achchaimae.aftas.member.dto;

import com.achchaimae.aftas.hunting.dto.HuntingReqDTO;
import com.achchaimae.aftas.member.Enum.IdentityDocumentType;
import com.achchaimae.aftas.ranking.dto.RankingReqDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MemberRespDTO {
    private int num;
    private String name ;
    private String familtyName ;
    private LocalDate accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
    private List<HuntingReqDTO> huntings;
    private List<RankingReqDTO> rankings;


}
