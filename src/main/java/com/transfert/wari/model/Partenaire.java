package com.transfert.wari.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(exclude = "users,comptes")
public class Partenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min=3, max = 50)
    private String entreprise;

    @NotBlank
    @Size(min=3, max = 50)
    private String ninea;

    @NotBlank
    @Size(min=3, max = 50)
    private String adresse;

    @NotBlank
    @Size(min=3, max = 50)
    private String statut;

    @OneToMany(mappedBy ="partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<User> users;

    @OneToMany(mappedBy ="partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<Compte> comptes;

    public Partenaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}

