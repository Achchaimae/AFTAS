package com.achchaimae.aftas.hunting;
import com.achchaimae.aftas.competition.Competition;
import com.achchaimae.aftas.competition.CompetitionRepository;
import com.achchaimae.aftas.fish.Fish;
import com.achchaimae.aftas.fish.FishRepository;
import com.achchaimae.aftas.hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.hunting.DTO.HuntingRespDTO;
import com.achchaimae.aftas.member.Member;
import com.achchaimae.aftas.member.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HuntingService implements HuntingServiceInterface {
    private final HuntingRepository huntingRepository;
    private  final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public HuntingService(HuntingRepository huntingRepository, CompetitionRepository competitionRepository, FishRepository fishRepository, MemberRepository memberRepository) {
        this.huntingRepository = huntingRepository;
        this.competitionRepository = competitionRepository;
        this.fishRepository = fishRepository;
        this.memberRepository = memberRepository;
    }

    @Autowired
    ModelMapper modelMapper;
    Optional<Competition> competition;
    Optional<Member> member;
    Optional<Fish> fish;
    public List<HuntingRespDTO> getHuntings(){
        return huntingRepository.findAll().stream().map(hunting -> modelMapper.map(hunting, HuntingRespDTO.class)).collect(Collectors.toList());
    }

    public HuntingRespDTO saveHunting(HuntingReqDTO hunting) {
    Hunting hunting1 = modelMapper.map(hunting,Hunting.class);
    competition = competitionRepository.findById(String.valueOf(hunting.getCompetition_Id()));
        member = memberRepository.findById(hunting.getMember_Id());
        fish = fishRepository.findById(String.valueOf(hunting.getFish_Id()));
        if(competition.isPresent() && member.isPresent() && fish.isPresent()){
            hunting1.setCompetition(competition.get());
            hunting1.setMember(member.get());
            hunting1.setFish(fish.get());
        }

    hunting1 = huntingRepository.save(hunting1);
    return modelMapper.map(hunting1,HuntingRespDTO.class);
    }

public HuntingRespDTO updateHunting(HuntingReqDTO hunting, Integer id) {
    return huntingRepository.findById(id)
            .map(existingHunting -> {
                existingHunting.setNumberOfFish(hunting.getNumberOfFish());
                Optional<Competition> competitionOptional = competitionRepository.findById(hunting.getCompetition_Id());
                Optional<Fish> fishOptional = fishRepository.findById(hunting.getFish_Id());
                Optional<Member> memberOptional = memberRepository.findById(hunting.getMember_Id());

                if (competitionOptional.isPresent() && memberOptional.isPresent() && fishOptional.isPresent()) {
                    existingHunting.setCompetition(competitionOptional.get());
                    existingHunting.setMember(memberOptional.get());
                    existingHunting.setFish(fishOptional.get());
                    return huntingRepository.save(existingHunting);
                } else {
                    throw new NotFoundException("Competition, member, or fish not found");
                }
            })
            .map(updatedHunting -> modelMapper.map(updatedHunting, HuntingRespDTO.class))
            .orElseThrow(() -> new NotFoundException("Hunting not found"));
}

    public Integer DeleteHunting(Integer huntingId){
        Optional<Hunting> exist = huntingRepository.findById(huntingId);

        if(exist.isPresent()){
            huntingRepository.deleteById(huntingId);
            return 1;
        }
        return 0;
    }
    public HuntingRespDTO findHunting(Integer huntingId) {
        Optional<Hunting> huntingOptional = huntingRepository.findById(huntingId);
        if (huntingOptional.isPresent()) {
            Hunting hunting = huntingOptional.get();
            return modelMapper.map(hunting, HuntingRespDTO.class);
        }
        return null;
    }


}
