package com.achchaimae.aftas.ranking;

import com.achchaimae.aftas.competition.Competition;
import com.achchaimae.aftas.hunting.Hunting;
import com.achchaimae.aftas.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking,Integer> {

    List<Ranking> findByIdCompetition(Competition competition);
    List<Ranking> findById_Competition_codeOrderByRankAsc(String searchTerm);
    List<Ranking> findById_Competition_code(String searchTerm);

    @Query("SELECT NEW Ranking (h.member, c, SUM(f.level.points * h.numberOfFish) AS score) " +
            "FROM Hunting h " +
            "JOIN h.fish f " +
            "JOIN h.competition c " +
            "WHERE c.code = :competitionCode " +
            "GROUP BY h.member, c " +
            "ORDER BY score DESC")
    List<Ranking> calculateRankingsForCompetition(@Param("competitionCode") String competitionCode);


    Optional<Ranking> findById_CompetitionAndId_Member(Competition competition, Member member);
}
