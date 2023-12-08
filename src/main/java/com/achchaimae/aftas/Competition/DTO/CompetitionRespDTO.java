package com.achchaimae.aftas.Competition.DTO;

import com.achchaimae.aftas.Hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.Ranking.DTO.RankingReqDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CompetitionRespDTO {
    private String code;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String Location;
    private Float amount ;
    private RankingReqDTO ranking;
    private HuntingReqDTO hunting;
}

