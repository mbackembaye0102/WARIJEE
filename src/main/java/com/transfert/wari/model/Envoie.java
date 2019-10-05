package com.transfert.wari.model;

import java.util.Date;

public class Envoie {
    private String code;
    private String prenom;
    private String nom;
    private Integer telephone;
    private String typePiece;
    private Integer numeroPiece;
    private String prenomb;
    private String nomb;
    private Integer telephoneb;
    private String typePieceb;
    private Integer numeroPieceb;
    private User guichetierEnvoie;
    private User getGuichetierRetrait;
    private Compte compte;
    private Integer montant;
    private Integer frais;
    private Integer total;
    private String etat;
    private Integer commissionEnvoie;
    private Integer commissionRetrait;
    private Integer commissionEtat;
    private Integer commissionWari;
    private Date dateEnvoie;
    private Date dateRetrait;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(String typePiece) {
        this.typePiece = typePiece;
    }

    public Integer getNumeroPiece() {
        return numeroPiece;
    }

    public void setNumeroPiece(Integer numeroPiece) {
        this.numeroPiece = numeroPiece;
    }

    public String getPrenomb() {
        return prenomb;
    }

    public void setPrenomb(String prenomb) {
        this.prenomb = prenomb;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public Integer getTelephoneb() {
        return telephoneb;
    }

    public void setTelephoneb(Integer telephoneb) {
        this.telephoneb = telephoneb;
    }

    public String getTypePieceb() {
        return typePieceb;
    }

    public void setTypePieceb(String typePieceb) {
        this.typePieceb = typePieceb;
    }

    public Integer getNumeroPieceb() {
        return numeroPieceb;
    }

    public void setNumeroPieceb(Integer numeroPieceb) {
        this.numeroPieceb = numeroPieceb;
    }

    public User getGuichetierEnvoie() {
        return guichetierEnvoie;
    }

    public void setGuichetierEnvoie(User guichetierEnvoie) {
        this.guichetierEnvoie = guichetierEnvoie;
    }

    public User getGetGuichetierRetrait() {
        return getGuichetierRetrait;
    }

    public void setGetGuichetierRetrait(User getGuichetierRetrait) {
        this.getGuichetierRetrait = getGuichetierRetrait;
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

    public Integer getFrais() {
        return frais;
    }

    public void setFrais(Integer frais) {
        this.frais = frais;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getCommissionEnvoie() {
        return commissionEnvoie;
    }

    public void setCommissionEnvoie(Integer commissionEnvoie) {
        this.commissionEnvoie = commissionEnvoie;
    }

    public Integer getCommissionRetrait() {
        return commissionRetrait;
    }

    public void setCommissionRetrait(Integer commissionRetrait) {
        this.commissionRetrait = commissionRetrait;
    }

    public Integer getCommissionEtat() {
        return commissionEtat;
    }

    public void setCommissionEtat(Integer commissionEtat) {
        this.commissionEtat = commissionEtat;
    }

    public Integer getCommissionWari() {
        return commissionWari;
    }

    public void setCommissionWari(Integer commissionWari) {
        this.commissionWari = commissionWari;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }
}
