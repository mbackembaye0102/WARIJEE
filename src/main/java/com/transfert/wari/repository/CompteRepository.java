package com.transfert.wari.repository;

import com.transfert.wari.model.Compte;
import com.transfert.wari.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
//    Optional<Compte> findByNumeroCompte(String numeroCompte);
//    Boolean existsByNumeroCompte(String numeroCompte);
}