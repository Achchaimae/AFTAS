package com.achchaimae.aftas.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByName(String name);

    Optional<Member> findByNameOrFamiltyName(String name, String familyName);
}
