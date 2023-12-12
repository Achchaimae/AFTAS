package com.achchaimae.aftas.competition.DTO;

import com.achchaimae.aftas.hunting.DTO.HuntingReqDTO;
import com.achchaimae.aftas.ranking.DTO.RankingReqDTO;
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
    private List<RankingReqDTO> ranking;
    private List<HuntingReqDTO> hunting;
}

