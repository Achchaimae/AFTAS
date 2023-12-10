package com.achchaimae.aftas.ranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking,Integer> {
}
