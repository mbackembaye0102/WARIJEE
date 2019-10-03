package com.transfert.wari.repository;

import com.transfert.wari.model.Compte;
import com.transfert.wari.model.Depot;
import com.transfert.wari.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Long> {
//    Optional<Compte> findByNumeroCompte(String numeroCompte);
//    Boolean existsByNumeroCompte(String numeroCompte);

    @Query("SELECT d FROM Depot d WHERE d.user = :user AND d.compte = :compte")
    List<Depot> findMesDepots(@Param("user") User user, @Param("compte") Compte compte);
}