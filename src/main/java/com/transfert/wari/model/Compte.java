package com.transfert.wari.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "partenaire_id" ,referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("compte")
    private Partenaire partenaire;

    @OneToMany(mappedBy ="compte")
    @JsonIgnoreProperties("compte")
    private List <Depot> depots;


    @NotBlank
    @Size(min=3, max = 50)
    private Double numerocompte;

    @NotBlank
    @Size(min=3, max = 50)
    private Double solde;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Double getNumerocompte() {
        return numerocompte;
    }

    public void setNumerocompte(Double numerocompte) {
        this.numerocompte = numerocompte;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public List<Depot> getDepots() {
        return depots;
    }

    public void setDepots(List<Depot> depots) {
        this.depots = depots;
    }
}
