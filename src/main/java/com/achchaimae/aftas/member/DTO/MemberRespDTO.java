package com.achchaimae.aftas.member.DTO;

import com.achchaimae.aftas.hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.member.Enum.IdentityDocumentType;
import com.achchaimae.aftas.ranking.DTO.RankingReqDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRespDTO {
    private int num;
    private String name ;
    private String familtyName ;
    private LocalDate accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
    private HuntingReqDTO huntings;
    private RankingReqDTO rankings;


}
