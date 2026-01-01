package com.AZTradingCC.inventory_tracker.repository;

import com.AZTradingCC.inventory_tracker.model.PokemonSealed;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PokemonSealedRepository extends JpaRepository<PokemonSealed, Long> {

    @Query("""
           SELECT s FROM PokemonSealed s
           WHERE (:id IS NULL OR s.id = :id)
             AND (:name IS NULL OR :name = '' OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%')))
             AND (:productType ISq NULL OR :productType = '' OR s.productType = :productType)
             AND (:specialty IS NULL OR :specialty = '' OR LOWER(s.specialty) LIKE LOWER(CONCAT('%', :specialty, '%')))
           """)
    List<PokemonSealed> findWithFilters(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("productType") String productType,
            @Param("specialty") String specialty
    );
}
