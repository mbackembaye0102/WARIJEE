package com.transfert.wari.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min=7, max = 15)
    private int montant;

    @NotBlank
    private DateTimeFormat dateDepot;


    @JoinColumn(name = "compte_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    //@JsonManagedReference
    // @JsonIgnoreProperties("employes")
    private Compte compte ;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)

    private User user ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public DateTimeFormat getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(DateTimeFormat dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
