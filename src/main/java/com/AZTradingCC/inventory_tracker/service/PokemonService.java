package com.AZTradingCC.inventory_tracker.service;

import com.AZTradingCC.inventory_tracker.model.PokemonSingles;
import com.AZTradingCC.inventory_tracker.model.PokemonSealed;
import com.AZTradingCC.inventory_tracker.dto.PokemonSinglesSearch;
import com.AZTradingCC.inventory_tracker.dto.PokemonSealedSearch;
import com.AZTradingCC.inventory_tracker.repository.PokemonSinglesRepository;
import com.AZTradingCC.inventory_tracker.repository.PokemonSealedRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PokemonService {

    private final PokemonSinglesRepository singlesRepo;
    private final PokemonSealedRepository sealedRepo;

    public PokemonService(PokemonSinglesRepository singlesRepo, PokemonSealedRepository sealedRepo) {
        this.singlesRepo = singlesRepo;
        this.sealedRepo = sealedRepo;
    }

    public List<PokemonSingles> searchSingles(PokemonSinglesSearch q) {
        if (q.useGraded()) {
            return singlesRepo.findGradedMode(
                    q.getId(),
                    q.getName(),
                    q.getCollectorNumber(),
                    q.getGradedCompany(),
                    q.getGraded(),
                    q.getSpecialty(),
                    q.getSet(),
                    q.getYear()
            );
        } else {
            return singlesRepo.findConditionMode(
                    q.getId(),
                    q.getName(),
                    q.getCollectorNumber(),
                    q.getCondition(),
                    q.getSpecialty(),
                    q.getSet(),
                    q.getYear()
            );
        }
    }

    public List<PokemonSealed> searchSealed(PokemonSealedSearch q) {
        return sealedRepo.findWithFilters(
                q.getId(),
                q.getName(),
                q.getProductType(),
                q.getSpecialty(),
                q.getSet(),
                q.getYear(),
                q.getQuantity()
        );
    }

    public List<PokemonSingles> allSingles() {
        return singlesRepo.findAll();
    }

    public List<PokemonSealed> allSealed() {
        return sealedRepo.findAll();
    }

    public PokemonSingles updateSinglesPrice(Long id, BigDecimal price) {
        PokemonSingles card = singlesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Single card not found"));

        card.setPrice(price);
        card.setLastUpdated(LocalDateTime.now());
        card.setVerified(true);

        return singlesRepo.save(card);
    }

    public PokemonSingles verifySinglesPrice(Long id) {
        PokemonSingles card = singlesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Single card not found"));

        card.setLastUpdated(LocalDateTime.now());
        card.setVerified(true);

        return singlesRepo.save(card);
    }

    public PokemonSealed updateSealedPrice(Long id, BigDecimal price) {
        PokemonSealed product = sealedRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sealed product not found"));

        product.setPrice(price);
        product.setLastUpdated(LocalDateTime.now());
        product.setVerified(true);

        return sealedRepo.save(product);
    }

    public PokemonSealed verifySealedPrice(Long id) {
        PokemonSealed product = sealedRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sealed product not found"));

        product.setLastUpdated(LocalDateTime.now());
        product.setVerified(true);

        return sealedRepo.save(product);
    }

    public List<PokemonSealed> getSealedStock() {
        return sealedRepo.findInStock();
    }
}