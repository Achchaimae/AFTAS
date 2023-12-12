package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.competition.DTO.CompetitionReqDTO;
import com.achchaimae.aftas.competition.DTO.CompetitionRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompetitionServiceInterface {
//    List<CompetitionRespDTO> getCompetitions();
//    Page<CompetitionRespDTO> getCompetitions(Pageable pageable);
    CompetitionRespDTO saveCompetition(CompetitionReqDTO competition);
    CompetitionRespDTO updateCompetition(CompetitionReqDTO competition, String code);
    Integer DeleteCompetition(String code);
    CompetitionRespDTO findCompetition(String code);
}
