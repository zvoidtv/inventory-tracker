package com.AZTradingCC.inventory_tracker.controllers;

import com.AZTradingCC.inventory_tracker.dto.PokemonSinglesSearch;
import com.AZTradingCC.inventory_tracker.dto.PokemonSealedSearch;
import com.AZTradingCC.inventory_tracker.model.PokemonSingles;
import com.AZTradingCC.inventory_tracker.model.PokemonSealed;
import com.AZTradingCC.inventory_tracker.service.PokemonService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/inventory")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public String getPokemonPage(CsrfToken csrfToken, Authentication authentication, Model model) {
        csrfToken.getToken(); // forces token creation

        boolean canEdit = authentication != null &&
                authentication.getAuthorities().stream()
                        .anyMatch(a -> "ROLE_ADMIN".equals(a.getAuthority()));

        model.addAttribute("canEdit", canEdit);
        return "PokemonSearch";
    }

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
            @RequestParam(required = false) String productTypeQuery,
            @RequestParam(required = false) String set,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) BigDecimal price,
            @RequestParam(required = false) LocalDateTime timeStmp,
            @RequestParam(required = false) Boolean verified,
            @RequestParam(required = false) String specialtyQuery
    ) {
        if ("singles".equals(type)) {
            PokemonSinglesSearch search = new PokemonSinglesSearch();
            if (idQuery != null) search.setId(idQuery);
            search.setName(nameQuery);
            search.setCondition(conditionQuery);
            search.setGradedCompany(gradedCompanyQuery);
            search.setGraded(gradedValueQuery);
            search.setCollectorNumber(collectorNumberQuery);
            search.setSet(set);
            search.setYear(year);
            search.setPrice(price);
            search.setTimeStamp(timeStmp);
            search.setVerified(verified);
            search.setSpecialty(specialtyQuery);
            return pokemonService.searchSingles(search);
        } else {
            PokemonSealedSearch search = new PokemonSealedSearch();
            if (idQuery != null) search.setId(idQuery);
            search.setName(nameQuery);
            search.setProductType(productTypeQuery);
            search.setSet(set);
            search.setYear(year);
            search.setPrice(price);
            search.setTimeStamp(timeStmp);
            search.setVerified(verified);
            search.setSpecialty(specialtyQuery);
            return pokemonService.searchSealed(search);
        }
    }

    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/pokemon/singles/{id}/price", produces = "application/json")
    public PokemonSingles updateSinglesPrice(
            @PathVariable Long id,
            @RequestParam BigDecimal price
    ) {
        return pokemonService.updateSinglesPrice(id, price);
    }

    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/pokemon/singles/{id}/verify", produces = "application/json")
    public PokemonSingles verifySinglesPrice(@PathVariable Long id) {
        return pokemonService.verifySinglesPrice(id);
    }

    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/pokemon/sealed/{id}/price", produces = "application/json")
    public PokemonSealed updateSealedPrice(
            @PathVariable Long id,
            @RequestParam BigDecimal price
    ) {
        return pokemonService.updateSealedPrice(id, price);
    }

    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/pokemon/sealed/{id}/verify", produces = "application/json")
    public PokemonSealed verifySealedPrice(@PathVariable Long id) {
        return pokemonService.verifySealedPrice(id);
    }

    @GetMapping("/pokemon/sealed/print")
    public String getPokemonSealedPrintPage(CsrfToken csrfToken) {
        csrfToken.getToken();
        return "PokemonSealedPrint";
    }

    @ResponseBody
    @GetMapping(value = "/pokemon/sealed/print/data", produces = "application/json")
    public List<PokemonSealed> getSealedPrintData() {
        return pokemonService.getSealedStock();
    }

    @GetMapping("/pokemon/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String getPokemonEditPage(CsrfToken csrfToken, Authentication authentication, Model model) {
        csrfToken.getToken();

        boolean canEdit = authentication != null &&
                authentication.getAuthorities().stream()
                        .anyMatch(a -> "ROLE_ADMIN".equals(a.getAuthority()));

        model.addAttribute("canEdit", canEdit);
        return "PokemonEdit";
    }
}