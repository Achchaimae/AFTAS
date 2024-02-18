package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.competition.dto.CompetitionReqDTO;
import com.achchaimae.aftas.competition.dto.CompetitionRespDTO;

public interface CompetitionServiceInterface {
    CompetitionRespDTO saveCompetition(CompetitionReqDTO competition);
    CompetitionRespDTO updateCompetition(CompetitionReqDTO competition, String code);
    Integer DeleteCompetition(String code);
    CompetitionRespDTO findCompetition(String code);
}
