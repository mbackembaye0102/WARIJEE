package com.transfert.wari.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min=3, max = 50)
    private String code;

    @NotBlank
    @Size(min=3, max = 50)
    private String prenom;

    @NotBlank
    @Size(min=3, max = 50)
    private String nom;


    @NotBlank
    @Size(min=7, max = 15)
    private int telephone;

    @NotBlank
    @Size(min=3, max = 50)
    @Autowired(required = false)
    private String typePiece;


    @NotBlank
    @Size(min=7, max = 20)
    @Autowired(required = false)
    private int numeroPiece;

    @NotBlank
    @Size(min=3, max = 50)
    private String prenomb;

    @NotBlank
    @Size(min=3, max = 50)
    private String nomb;


    @NotBlank
    @Size(min=7, max = 15)
    private int telephoneb;

    @NotBlank
    @Size(min=3, max = 50)
    @Autowired(required = false)
    private String typePieceb;


    @NotBlank
    @Size(min=7, max = 20)
    @Autowired(required = false)
    private int numeroPieceb;


    @NotBlank
    @Size(min=4, max = 30)
    private int montant;

    @NotBlank
    @Size(min=4, max = 30)
    private int frais;

    @NotBlank
    @Size(min=4, max = 30)
    private int total;

    @NotBlank
    @Size(min=4, max = 30)
    private int commissionWari;

    @NotBlank
    @Size(min=4, max = 30)
    private int commissionEnvoie;

    @NotBlank
    @Size(min=4, max = 30)
    private int commissionRetrait;

    @NotBlank
    @Size(min=4, max = 30)
    private int commissionEtat;

    @NotBlank
    @Autowired(required = false)
    private DateTimeFormat dateEnvoie;

    @NotBlank
    @Autowired(required = false)
    private DateTimeFormat dateRetrait;

    @JoinColumn(name = "guichetier_envoie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    private User guichetierEnvoie ;


    @JoinColumn(name = "guichetier_Retrait_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    private User guichetierRetrait ;

    @NotBlank
    @Size(min=3, max = 50)
    private String etat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(String typePiece) {
        this.typePiece = typePiece;
    }

    public int getNumeroPiece() {
        return numeroPiece;
    }

    public void setNumeroPiece(int numeroPiece) {
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

    public int getTelephoneb() {
        return telephoneb;
    }

    public void setTelephoneb(int telephoneb) {
        this.telephoneb = telephoneb;
    }

    public String getTypePieceb() {
        return typePieceb;
    }

    public void setTypePieceb(String typePieceb) {
        this.typePieceb = typePieceb;
    }

    public int getNumeroPieceb() {
        return numeroPieceb;
    }

    public void setNumeroPieceb(int numeroPieceb) {
        this.numeroPieceb = numeroPieceb;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getFrais() {
        return frais;
    }

    public void setFrais(int frais) {
        this.frais = frais;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCommissionWari() {
        return commissionWari;
    }

    public void setCommissionWari(int commissionWari) {
        this.commissionWari = commissionWari;
    }

    public int getCommissionEnvoie() {
        return commissionEnvoie;
    }

    public void setCommissionEnvoie(int commissionEnvoie) {
        this.commissionEnvoie = commissionEnvoie;
    }

    public int getCommissionRetrait() {
        return commissionRetrait;
    }

    public void setCommissionRetrait(int commissionRetrait) {
        this.commissionRetrait = commissionRetrait;
    }

    public int getCommissionEtat() {
        return commissionEtat;
    }

    public void setCommissionEtat(int commissionEtat) {
        this.commissionEtat = commissionEtat;
    }

    public DateTimeFormat getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(DateTimeFormat dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public DateTimeFormat getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(DateTimeFormat dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public User getGuichetierEnvoie() {
        return guichetierEnvoie;
    }

    public void setGuichetierEnvoie(User guichetierEnvoie) {
        this.guichetierEnvoie = guichetierEnvoie;
    }

    public User getGuichetierRetrait() {
        return guichetierRetrait;
    }

    public void setGuichetierRetrait(User guichetierRetrait) {
        this.guichetierRetrait = guichetierRetrait;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
