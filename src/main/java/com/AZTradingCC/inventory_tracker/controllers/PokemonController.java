package com.AZTradingCC.inventory_tracker.controllers;

import com.AZTradingCC.inventory_tracker.dto.PokemonSinglesSearch;
import com.AZTradingCC.inventory_tracker.dto.PokemonSealedSearch;
import com.AZTradingCC.inventory_tracker.model.PokemonSingles;
import com.AZTradingCC.inventory_tracker.model.PokemonSealed;
import com.AZTradingCC.inventory_tracker.service.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/inventory")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // 1️⃣ Serve the HTML page
    @GetMapping("/pokemon")
    public String getPokemonPage() {
        return "PokemonSearch"; // make sure your template is named PokemonSearch.html
    }

    // 2️⃣ JSON endpoint for searches
    @ResponseBody
    @GetMapping(value = "/pokemon/search", produces = "application/json")
    public List<?> searchPokemon(
            @RequestParam String type,
            @RequestParam(required = false) String nameQuery,
            @RequestParam(required = false) Long idQuery,
            @RequestParam(required = false) String conditionQuery,
            @RequestParam(required = false) String gradedCompanyQuery,
            @RequestParam(required = false) String gradedValueQuery,
            @RequestParam(required = false) String collectorNumberQuery,
            @RequestParam(required = false) String productTypeQuery
    ) {
        if ("singles".equals(type)) {
            PokemonSinglesSearch search = new PokemonSinglesSearch();
            if (idQuery != null) search.setId(idQuery);
            search.setName(nameQuery);
            search.setCondition(conditionQuery);
            search.setGradedCompany(gradedCompanyQuery);
            search.setGraded(gradedValueQuery);
            search.setCollectorNumber(collectorNumberQuery);
            return pokemonService.searchSingles(search);
        } else {
            PokemonSealedSearch search = new PokemonSealedSearch();
            if (idQuery != null) search.setId(idQuery);
            search.setName(nameQuery);
            search.setProductType(productTypeQuery);
            return pokemonService.searchSealed(search);
        }
    }
}

