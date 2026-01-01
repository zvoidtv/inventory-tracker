package com.AZTradingCC.inventory_tracker.repository;

import com.AZTradingCC.inventory_tracker.model.PokemonSingles;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PokemonSinglesRepository extends JpaRepository<PokemonSingles, Long> {

    @Query("""
           SELECT p FROM PokemonSingles p
           WHERE (:id IS NULL OR p.id = :id)
             AND (:name IS NULL OR :name = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
             AND (:collectorNumber IS NULL OR :collectorNumber = '' OR p.collectorNumber = :collectorNumber)
             AND (:condition IS NULL OR :condition = '' OR LOWER(p.condition) LIKE LOWER(CONCAT('%', :condition, '%')))
             AND (:gradedCompany IS NULL OR :gradedCompany = '' OR LOWER(p.gradedCompany) LIKE LOWER(CONCAT('%', :gradedCompany, '%')))
             AND (:graded IS NULL OR :graded = '' OR LOWER(p.graded) LIKE LOWER(CONCAT('%', :graded, '%')))
             AND (:specialty IS NULL OR :specialty = '' OR LOWER(p.specialty) LIKE LOWER(CONCAT('%', :specialty, '%')))
           """)
    List<PokemonSingles> findGradedMode(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("collectorNumber") String collectorNumber,
            @Param("gradedCompany") String gradedCompany,
            @Param("graded") String graded,
            @Param("specialty") String specialty
    );

    @Query("""
           SELECT p FROM PokemonSingles p
           WHERE (:id IS NULL OR p.id = :id)
             AND (:name IS NULL OR :name = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
             AND (:collectorNumber IS NULL OR :collectorNumber = '' OR p.collectorNumber = :collectorNumber)
             AND (:condition IS NULL OR :condition = '' OR LOWER(p.condition) LIKE LOWER(CONCAT('%', :condition, '%')))
             AND (:specialty IS NULL OR :specialty = '' OR LOWER(p.specialty) LIKE LOWER(CONCAT('%', :specialty, '%')))
           """)
    List<PokemonSingles> findConditionMode(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("collectorNumber") String collectorNumber,
            @Param("condition") String condition,
            @Param("specialty") String specialty
    );
}
