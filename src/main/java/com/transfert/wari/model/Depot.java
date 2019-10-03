package com.transfert.wari.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "compte_id" ,referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depot")
    private Compte compte;


    private Integer montant;

    @DateTimeFormat(pattern ="yyyy-MM-dd-mm-ss")
    private Date dateDepot;
    @JsonIgnore
    @JoinColumn(name = "caissier_id" ,referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depot")
    private User user;

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compte getCompte(Compte compte) {
        return this.compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
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
}
