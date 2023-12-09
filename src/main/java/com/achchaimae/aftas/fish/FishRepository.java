package com.achchaimae.aftas.fish;

import com.achchaimae.aftas.level.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FishRepository extends JpaRepository<Fish, String> {
    Optional<Fish> findById(String name);
}
