package com.achchaimae.aftas.hunting;

import com.achchaimae.aftas.competition.Competition;
import com.achchaimae.aftas.fish.Fish;
import com.achchaimae.aftas.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting, Integer> {
    Optional<Hunting> findByFishAndMemberAndCompetition(Fish fish, Member member, Competition competition);

    List<Hunting> findByMemberAndCompetition(Member member, Competition competition);
}
