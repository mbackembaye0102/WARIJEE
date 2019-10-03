package com.transfert.wari.model;

import java.util.Date;

public class AccountUser {

    private String username;
    private Compte compte;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
