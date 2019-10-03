package com.transfert.wari.repository;

import com.transfert.wari.model.Partenaire;
import com.transfert.wari.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    Optional<Partenaire> findByEntreprise(String entreprise);
    Boolean existsByEntreprise(String entreprise);
}