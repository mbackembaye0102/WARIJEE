package com.transfert.wari.model;

import java.util.Date;

public class RegistrationUser {
//POUR USER
    private String name;
    private String username;
    private String password;
    private String telephone;
    private String statut;
    private Long profil;
    private Partenaire partenaire;
    private Compte compte;

    //POUR DEPOT
    private Integer montant;
    private Date dateDepot;
    private User user;
    private Compte compteDepot;
    private String numeroCompte;

    //POUR TARIF
    private  Integer borneInferieure;
    private  Integer borneSuperieure;
    private  Integer valeur;


    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getProfil() {
        return profil;
    }

    public void setProfil(Long profil) {
        this.profil = profil;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }


    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Compte getCompteDepot() {
        return compteDepot;
    }

    public void setCompteDepot(Compte compteDepot) {
        this.compteDepot = compteDepot;
    }

    public Integer getBorneInferieure() {
        return borneInferieure;
    }

    public void setBorneInferieure(Integer borneInferieure) {
        this.borneInferieure = borneInferieure;
    }

    public Integer getBorneSuperieure() {
        return borneSuperieure;
    }

    public void setBorneSuperieure(Integer borneSuperieure) {
        this.borneSuperieure = borneSuperieure;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }
}
