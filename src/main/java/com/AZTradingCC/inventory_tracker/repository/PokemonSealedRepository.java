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
             AND (:productType IS NULL OR :productType = '' OR LOWER(s.productType) LIKE LOWER(CONCAT('%', :productType, '%')))
             AND (:specialty IS NULL OR :specialty = '' OR LOWER(s.specialty) LIKE LOWER(CONCAT('%', :specialty, '%')))
             AND (:set IS NULL OR :set = '' OR LOWER(s.set) LIKE LOWER (CONCAT('%', :set, '%')))
             AND (:year IS NULL OR s.year = :year)
             AND (:quantity IS NULL OR s.quantity = :quantity)
           """)
    List<PokemonSealed> findWithFilters(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("productType") String productType,
            @Param("specialty") String specialty,
            @Param("set") String set,
            @Param("year") Integer year,
            @Param("quantity") Integer quantity
    );

    @Query("""
           SELECT s FROM PokemonSealed s
           WHERE s.quantity >= 1
           ORDER BY
               CASE WHEN s.productType IS NULL THEN 1 ELSE 0 END,
               s.productType,
               s.name
           """)
    List<PokemonSealed> findInStock();
}
