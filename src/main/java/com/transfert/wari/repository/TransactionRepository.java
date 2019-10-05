package com.transfert.wari.repository;

import com.transfert.wari.model.Compte;
import com.transfert.wari.model.Depot;
import com.transfert.wari.model.Transaction;
import com.transfert.wari.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Object> findTransactionByCode(String code);

//    Optional<Compte> findByNumeroCompte(String numeroCompte);
//    Boolean existsByNumeroCompte(String numeroCompte);

}