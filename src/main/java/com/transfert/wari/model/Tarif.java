package com.transfert.wari.model;

import com.transfert.wari.repository.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int borneInferieure;
    private  int getBorneSuperieure;
    private int valeur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorneInferieure() {
        return borneInferieure;
    }

    public void setBorneInferieure(int borneInferieure) {
        this.borneInferieure = borneInferieure;
    }

    public int getGetBorneSuperieure() {
        return getBorneSuperieure;
    }

    public void setGetBorneSuperieure(int getBorneSuperieure) {
        this.getBorneSuperieure = getBorneSuperieure;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

//    @Autowired
//    private TarifRepository tarifRepository;
//    public List<Tarif> findAll() {
//        var tarifs = tarifRepository.findAll();
//    return tarifs;
//
//    }
}
