package com.transfert.wari.repository;

import com.transfert.wari.model.Compte;
import com.transfert.wari.model.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Long> {
//    Optional<Compte> findByNumeroCompte(String numeroCompte);
//    Boolean existsByNumeroCompte(String numeroCompte);
}