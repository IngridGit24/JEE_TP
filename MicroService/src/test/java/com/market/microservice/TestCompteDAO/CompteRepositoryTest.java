package com.market.microservice.TestCompteDAO;

import com.market.microservice.Entities.Compte;
import com.market.microservice.Repositories.CompteRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@Transactional
@Rollback
public class CompteRepositoryTest {

    @Autowired
    private CompteRepository compteRepository;

    @Test
    public void testCreateCompte(){
        Compte compte = new Compte();
        compte.setCode(2453);
        compte.setSolde(150650.90);
        compte.setProprietaire("Jean Remy");

        Compte savedCompte = compteRepository.save(compte);

        // Assertions with diagnostic messages
        assertThat(savedCompte).isNotNull().withFailMessage("Le compte sauvegardé ne doit pas être nul.");
        assertThat(savedCompte.getId()).isNotNull().withFailMessage("L'ID du compte sauvegardé ne doit pas être nul.");
    }

    @Test
    public void testFindCompteById() {
        Compte compte = new Compte();
        compte.setCode(2288);
        compte.setSolde(13650.90);
        compte.setProprietaire("MBA Assoumou Arnold");
        Compte savedCompte = compteRepository.save(compte);

        Optional<Compte> foundCompte = compteRepository.findById(savedCompte.getId());

        // Assertions with diagnostic messages
        assertThat(foundCompte).isPresent().withFailMessage("Le compte trouvé ne doit pas être vide.");
        assertThat(foundCompte.get().getProprietaire()).isEqualTo("MBA Assoumou Arnold")
                .withFailMessage("Le propriétaire du compte trouvé ne correspond pas à la valeur attendue.");
    }

    @Test
    public void testUpdateCompte() {
        Compte compte = new Compte();
        compte.setCode(3761);
        compte.setSolde(1750.0);
        compte.setProprietaire("Jean Marie");
        Compte savedCompte = compteRepository.save(compte);

        savedCompte.setProprietaire("Jean Marie Updated");
        savedCompte.setSolde(2000.0);
        Compte updatedCompte = compteRepository.save(savedCompte);

        // Assertions with diagnostic messages
        assertThat(updatedCompte.getProprietaire()).isEqualTo("Jean Marie Updated")
                .withFailMessage("Le nom du propriétaire après mise à jour ne correspond pas à la valeur attendue.");
        assertThat(updatedCompte.getSolde()).isEqualTo(2000.0)
                .withFailMessage("Le solde après mise à jour ne correspond pas à la valeur attendue.");
    }

    @Test
    public void testDeleteCompte() {
        Compte compte = new Compte();
        compte.setCode(3067);
        compte.setSolde(20500);
        compte.setProprietaire("Marie Antoinette");
        Compte savedCompte = compteRepository.save(compte);

        compteRepository.deleteById(savedCompte.getId());

        Optional<Compte> deletedCompte = compteRepository.findById(savedCompte.getId());

        // Assertions with diagnostic messages
        assertThat(deletedCompte).isNotPresent().withFailMessage("Le compte supprimé ne doit pas être présent.");
    }

    @Test
    public void testFindAllComptes() {
        Compte compte1 = new Compte();
        compte1.setCode(2244);
        compte1.setSolde(1000.0);
        compte1.setProprietaire("Jean De Dieu");
        compteRepository.save(compte1);

        Compte compte2 = new Compte();
        compte2.setCode(3567);
        compte2.setSolde(6900.0);
        compte2.setProprietaire("Ruan Martez");
        compteRepository.save(compte2);

        List<Compte> comptes = compteRepository.findAll();

        // Assertions with diagnostic messages
        assertThat(comptes).isNotNull().withFailMessage("La liste des comptes ne doit pas être nulle.");
        assertThat(comptes).hasSize(2).withFailMessage("La taille de la liste des comptes n'est pas 2.");

        // Use a tuple to extract multiple properties at once
        assertThat(comptes)
                .extracting(Compte::getProprietaire, Compte::getCode, Compte::getSolde)
                .containsExactlyInAnyOrder(
                        tuple("Jean De Dieu", 2244, 1000.0),
                        tuple("Ruan Martez", 3567, 6900.0)
                )
                .withFailMessage("Les propriétés extraites de la liste des comptes ne correspondent pas aux valeurs attendues.");
    }

}
