package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.Exception.RecordAlreadyExistsException;
import com.achchaimae.aftas.Exception.ResourceNotFoundException;
import com.achchaimae.aftas.competition.Enum.Etat;
import com.achchaimae.aftas.competition.dto.CompetitionReqDTO;
import com.achchaimae.aftas.competition.dto.CompetitionRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class CompetitionService implements CompetitionServiceInterface{
    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }
    @Autowired
    ModelMapper modelMapper;


    public Page<CompetitionRespDTO> getCompetitions(Pageable pageable) {

        Page<Competition> competitions = competitionRepository.findAll(pageable);
        competitions.getContent().forEach(competition -> {
            int result = competition.getDate().compareTo(LocalDate.now());
            long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(), competition.getDate());
            if (result < 0) {
                competition.setEtat(Etat.close);
            } else if (result > 0) {
                if (daysDifference == 1) {
                    competition.setEtat(Etat.one_day_remaining);
                }
                competition.setEtat(Etat.waiting);
            } else {
                competition.setEtat(Etat.Pending);
            }
            competitionRepository.save(modelMapper.map(competition,Competition.class));
        });
        Page<CompetitionRespDTO> competitionRespDTOS = competitions
                .map(competition -> modelMapper.map(competition, CompetitionRespDTO.class));
        return competitionRespDTOS;

    }

public CompetitionRespDTO saveCompetition(CompetitionReqDTO competition) {
    if (competitionRepository.existsByDate(competition.getDate())) {
        throw new RecordAlreadyExistsException("Competition with date " + competition.getDate() + " and city " + competition.getLocation() + " already exists.");
    }

    return modelMapper.map(competitionRepository.save(modelMapper.map(competition, Competition.class)), CompetitionRespDTO.class);
}

    public Page<CompetitionRespDTO> getAllWithPaginationByEtat(Pageable pageable, Etat etat) {
        Page<Competition> competitions = competitionRepository.findAllByEtat(etat, pageable);
        return competitions
                .map(competition -> modelMapper.map(competition, CompetitionRespDTO.class));
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
