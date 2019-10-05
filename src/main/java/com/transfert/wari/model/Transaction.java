package com.transfert.wari.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(exclude = "users,comptes")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max = 50)
    private String code;

    @Size(min=3, max = 50)
    private String prenom;

    @Size(min=3, max = 50)
    private String nom;


    private int telephone;


    @Size(min=3, max = 50)
    @Autowired(required = false)
    private String typePiece;



    @Autowired(required = false)
    private int numeroPiece;

    @Size(min=3, max = 50)
    private String prenomb;

    @Size(min=3, max = 50)
    private String nomb;



    private int telephoneb;

    @Size(min=3, max = 50)
    @Autowired(required = false)
    private String typePieceb;


    @Autowired(required = false)
    private int numeroPieceb;


    private int montant;

    private int frais;

    private int total;

    private int commissionWari;

    private int commissionEnvoie;


    private int commissionRetrait;

    private int commissionEtat;

    @Autowired(required = false)
    @DateTimeFormat(pattern ="yyyy-MM-dd-mm-ss")
    private Date dateEnvoie;


    @Autowired(required = false)
    @DateTimeFormat(pattern ="yyyy-MM-dd-mm-ss")
    private Date dateRetrait;

    @JoinColumn(name = "guichetier_envoie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    private User guichetierEnvoie ;


    @JoinColumn(name = "guichetier_Retrait_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    private User guichetierRetrait ;

    @Size(min=3, max = 50)
    private String etat;

    @JoinColumn(name = "compte_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    private Compte compte ;

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

    public Date getDateEnvoie(Date date) {
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

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
