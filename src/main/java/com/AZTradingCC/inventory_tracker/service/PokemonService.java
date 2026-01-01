package com.AZTradingCC.inventory_tracker.service;

import com.AZTradingCC.inventory_tracker.model.PokemonSingles;
import com.AZTradingCC.inventory_tracker.model.PokemonSealed;
import com.AZTradingCC.inventory_tracker.dto.PokemonSinglesSearch;
import com.AZTradingCC.inventory_tracker.dto.PokemonSealedSearch;
import com.AZTradingCC.inventory_tracker.repository.PokemonSinglesRepository;
import com.AZTradingCC.inventory_tracker.repository.PokemonSealedRepository;
import org.springframework.stereotype.Service;
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
                    q.getSpecialty()
            );
        } else {
            return singlesRepo.findConditionMode(
                    q.getId(),
                    q.getName(),
                    q.getCollectorNumber(),
                    q.getCondition(),
                    q.getSpecialty()
            );
        }
    }

    public List<PokemonSealed> searchSealed(PokemonSealedSearch q) {
        return sealedRepo.findWithFilters(
                q.getId(),
                q.getName(),
                q.getProductType(),
                q.getSpecialty()
        );
    }

    public List<PokemonSingles> allSingles() {
        return singlesRepo.findAll();
    }

    public List<PokemonSealed> allSealed() {
        return sealedRepo.findAll();
    }
}
