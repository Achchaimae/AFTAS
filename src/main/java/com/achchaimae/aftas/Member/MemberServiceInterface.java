package com.achchaimae.aftas.Member;

import com.achchaimae.aftas.Member.DTO.MemberReqDTO;
import com.achchaimae.aftas.Member.DTO.MemberRespDTO;

import java.util.List;

public interface MemberServiceInterface {
     List<MemberRespDTO> getMembers();
    MemberRespDTO saveMember(MemberReqDTO member);
    MemberRespDTO updateMember(MemberReqDTO member, Integer id);
    Integer DeleteMember(Integer memberId);
    MemberRespDTO findMember(Integer mediaId);


}
