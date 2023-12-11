package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.Exception.RecordAlreadyExistsException;
import com.achchaimae.aftas.Exception.ResourceNotFoundException;
import com.achchaimae.aftas.competition.DTO.CompetitionReqDTO;
import com.achchaimae.aftas.competition.DTO.CompetitionRespDTO;
import com.achchaimae.aftas.member.DTO.MemberReqDTO;
import com.achchaimae.aftas.member.DTO.MemberRespDTO;
import com.achchaimae.aftas.member.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetitionService implements CompetitionServiceInterface{
    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }
    @Autowired
    ModelMapper modelMapper;
    public List<CompetitionRespDTO> getCompetitions() {
        return competitionRepository.findAll().stream().map(competition -> modelMapper.map(competition, CompetitionRespDTO.class)).collect(Collectors.toList());
    }

    public CompetitionRespDTO saveCompetition(CompetitionReqDTO competition) {
        return modelMapper.map(competitionRepository.save(modelMapper.map(competition, Competition.class)), CompetitionRespDTO.class);

    }


public CompetitionRespDTO updateCompetition(CompetitionReqDTO competition, String code) {
    Optional<Competition> competitionOptional = competitionRepository.findById(code);
    if (competitionOptional.isPresent()) {
        Competition existingCompetition = competitionOptional.get();
        existingCompetition.setCode(competition.getCode());

        return modelMapper.map(competitionRepository.save(existingCompetition), CompetitionRespDTO.class);
    } else {
        throw new ResourceNotFoundException("Competition with code " + code + " not found.");
    }
}

    public Integer DeleteCompetition(String code){
        Optional<Competition> exist = competitionRepository.findById(code);
        if(exist.isPresent()){
            competitionRepository.deleteById(code);
            return 1;
        }
        return 0;
    }

//    public CompetitionRespDTO findCompetition(String code) {
//        Optional<Competition> competitionOptional = competitionRepository.findById(code);
//        if (competitionOptional.isPresent()) {
//            Competition competition = competitionOptional.get();
//            return modelMapper.map(competition, CompetitionRespDTO.class);
//        }
//        return null;
//    }
    public CompetitionRespDTO findCompetition(String code) {
        Optional<Competition> competitionOptional = competitionRepository.findById(code);
        if (competitionOptional.isPresent()) {
            Competition competition = competitionOptional.get();
            return modelMapper.map(competition, CompetitionRespDTO.class);
        } else {
            throw new ResourceNotFoundException("Competition with code " + code + " not found.");
        }
    }

}
