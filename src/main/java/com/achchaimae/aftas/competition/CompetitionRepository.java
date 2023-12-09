package com.achchaimae.aftas.competition;

import com.achchaimae.aftas.fish.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetitionRepository  extends JpaRepository<Competition, String> {
    Optional<Competition> findById(String code);
}
