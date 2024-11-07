package com.market.microservice.Controller;

import com.market.microservice.Entities.Compte;
import com.market.microservice.Exceptions.ResourceNotFoundException;
import com.market.microservice.Repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    // Méthode GET pour récupérer tous les comptes
    @GetMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    // Méthode POST pour créer un compte
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compte createCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    // Méthode GET pour récupérer un compte par son ID
    @GetMapping("/{id}")
    public Compte getCompteById(@PathVariable Long id) {
        Optional<Compte> compte = compteRepository.findById(id);
        return compte.orElseThrow(() -> new ResourceNotFoundException("Compte non trouvé avec id " + id));
    }

    // Méthode PUT pour mettre à jour un compte existant
    @PutMapping("/{id}")
    public Compte updateCompte(@PathVariable Long id, @RequestBody Compte compteDetails) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compte non trouvé avec id " + id));

        compte.setCode(compteDetails.getCode());
        compte.setSolde(compteDetails.getSolde());
        compte.setProprietaire(compteDetails.getProprietaire());

        return compteRepository.save(compte);
    }

    // Méthode DELETE pour supprimer un compte par son ID
    @DeleteMapping("/{id}")
    public String deleteCompte(@PathVariable Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compte non trouvé avec id " + id));

        compteRepository.delete(compte);
        return "Compte supprimé avec succès!";
    }
}
