package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.competition.DTO.CompetitionReqDTO;
import com.achchaimae.aftas.competition.DTO.CompetitionRespDTO;

import java.util.List;

public interface CompetitionServiceInterface {
    List<CompetitionRespDTO> getCompetitions();
    CompetitionRespDTO saveCompetition(CompetitionReqDTO competition);
    CompetitionRespDTO updateCompetition(CompetitionReqDTO competition, String code);
    Integer DeleteCompetition(String code);
    CompetitionRespDTO findCompetition(String code);
}
