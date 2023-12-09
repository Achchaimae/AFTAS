package com.achchaimae.aftas.member;

import com.achchaimae.aftas.member.DTO.MemberReqDTO;
import com.achchaimae.aftas.member.DTO.MemberRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService implements MemberServiceInterface{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    ModelMapper modelMapper;

    public List<MemberRespDTO> getMembers() {
        return memberRepository.findAll().stream().map(member -> modelMapper.map(member, MemberRespDTO.class)).collect(Collectors.toList());
    }

    public MemberRespDTO saveMember(MemberReqDTO member) {
        return modelMapper.map(memberRepository.save(modelMapper.map(member, Member.class)), MemberRespDTO.class);

    }

    public MemberRespDTO updateMember(MemberReqDTO member, Integer id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if(memberOptional.isPresent()){
            member.setNum(memberOptional.get().getNum());
            return modelMapper.map(memberRepository.save(modelMapper.map(member , Member.class)), MemberRespDTO.class);

        }
        return null;
    }


    public Integer DeleteMember(Integer memberId){
        Optional<Member> exist = memberRepository.findById(memberId);

        if(exist.isPresent()){
            memberRepository.deleteById(memberId);
            return 1;
        }
        return 0;
    }
    public MemberRespDTO findMember(Integer mediaId) {
        Optional<Member> memberOptional = memberRepository.findById(mediaId);
        if(memberOptional.isPresent()){
            return modelMapper.map(memberRepository.findById(mediaId) , MemberRespDTO.class);
        }
        return null;
    }
}
