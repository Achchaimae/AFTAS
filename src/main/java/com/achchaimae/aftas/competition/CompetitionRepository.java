package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.competition.Enum.Etat;
import com.achchaimae.aftas.fish.Fish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CompetitionRepository  extends JpaRepository<Competition, String> {
    Optional<Competition> findById(String code);
    boolean existsByDate(LocalDate date);
    Page<Competition> findAllByEtat(Etat etat, Pageable pageable);


}
