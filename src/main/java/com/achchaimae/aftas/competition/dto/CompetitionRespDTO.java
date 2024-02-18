package com.achchaimae.aftas.competition.dto;

import com.achchaimae.aftas.competition.Enum.Etat;
import com.achchaimae.aftas.hunting.dto.HuntingReqDTO;
import com.achchaimae.aftas.ranking.dto.RankingRespDTOForCompetition;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class CompetitionRespDTO {
    private String code;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String Location;
    private Float amount ;
    private Etat etat;

    private List<RankingRespDTOForCompetition> rankings;
    private List<HuntingReqDTO> hunting;
}

