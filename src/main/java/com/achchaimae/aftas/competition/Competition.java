package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.competition.Enum.Etat;
import com.achchaimae.aftas.hunting.Hunting;
import com.achchaimae.aftas.ranking.Ranking;
import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@Entity
public class Competition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String code;
    private LocalDate date;
    private LocalTime startTime;
    private  LocalTime endTime;
    private Integer numberOfParticipants;
    private String Location;
    private Float amount ;
    private Etat etat;

    @OneToMany(mappedBy = "id.competition",cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Ranking> rankings;
    @OneToMany(mappedBy = "competition",cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Hunting> huntings;

}
