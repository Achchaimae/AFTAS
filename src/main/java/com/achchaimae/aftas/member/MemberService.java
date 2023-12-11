package com.achchaimae.aftas.member;

import com.achchaimae.aftas.Exception.RecordAlreadyExistsException;
import com.achchaimae.aftas.Exception.ResourceNotFoundException;
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

//    public MemberRespDTO saveMember(MemberReqDTO member) {
//        return modelMapper.map(memberRepository.save(modelMapper.map(member, Member.class)), MemberRespDTO.class);
//
//    }
    public MemberRespDTO saveMember(MemberReqDTO member) {
        // Check if the member already exists
        if (memberRepository.existsById(member.getNum())) {
            throw new RecordAlreadyExistsException("Member with num " + member.getNum() + " already exists.");
        }

        return modelMapper.map(memberRepository.save(modelMapper.map(member, Member.class)), MemberRespDTO.class);
    }

public MemberRespDTO updateMember(MemberReqDTO member, Integer id) {
    Optional<Member> memberOptional = memberRepository.findById(id);
    if (memberOptional.isPresent()) {
        Member existingMember = memberOptional.get();
        if (existingMember.getNum() != member.getNum() && memberRepository.existsById(member.getNum())) {
            throw new RecordAlreadyExistsException("Member with num " + member.getNum() + " already exists.");
        }
        member.setNum(Integer.valueOf(existingMember.getNum())); // Convert int to Integer
        return modelMapper.map(memberRepository.save(modelMapper.map(member, Member.class)), MemberRespDTO.class);
    } else {
        throw new ResourceNotFoundException("Member with id " + id + " not found.");
    }
}

    public Integer DeleteMember(Integer memberId){
        Optional<Member> exist = memberRepository.findById(memberId);

        if(exist.isPresent()){
            memberRepository.deleteById(memberId);
            return 1;
        }
        return 0;
    }

    public MemberRespDTO findMember(Integer memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            return modelMapper.map(member, MemberRespDTO.class);
        }
        return null;
    }
}
