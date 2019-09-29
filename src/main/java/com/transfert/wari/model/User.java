package com.transfert.wari.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @NotBlank
    @Size(min=3, max = 50)
    private String nomComplet;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @NotBlank
    @Size(min=3, max = 10)
    private String statut;

    @NotBlank
    @Size(min=7, max = 15)
    private int telephone;

    @JoinColumn(name = "partenaire_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)
    //@JsonManagedReference
   // @JsonIgnoreProperties("employes")
    private Partenaire partenaire ;

    @JoinColumn(name = "profil_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)

    private Profil profil ;

    @JoinColumn(name = "compte_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Autowired(required = false)

    private Compte compte ;

    @NotBlank
    private DateTimeFormat updatedAt;

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public DateTimeFormat getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTimeFormat updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @NotBlank
    @Size(min=7, max = 15)
    private String imageName;




    public User() {}

    public User(String nomComplet, String username, String password) {
        this.nomComplet = nomComplet;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void SetNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}