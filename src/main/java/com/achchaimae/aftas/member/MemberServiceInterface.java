package com.achchaimae.aftas.member;

import com.achchaimae.aftas.member.dto.MemberReqDTO;
import com.achchaimae.aftas.member.dto.MemberRespDTO;

import java.util.List;

public interface MemberServiceInterface {
     List<MemberRespDTO> getMembers();
    MemberRespDTO saveMember(MemberReqDTO member);
    MemberRespDTO updateMember(MemberReqDTO member, Integer id);
    Integer DeleteMember(Integer memberId);
    MemberRespDTO findMember(Integer mediaId);


}
