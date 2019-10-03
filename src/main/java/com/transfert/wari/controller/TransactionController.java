package com.transfert.wari.controller;

import com.transfert.wari.model.*;
import com.transfert.wari.repository.CompteRepository;
import com.transfert.wari.repository.DepotRepository;
import com.transfert.wari.repository.UserRepository;
import com.transfert.wari.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepotRepository depotRepository;

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(value = "/listeCompte")
    public  List<Compte> listeCompte() {
        return compteRepository.findAll();
    }

    @GetMapping(value = "/listeDepot")
    public  List<Depot> listeDepot() {
        return depotRepository.findAll();
    }


    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/addDepot",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> add (@RequestBody(required = false) RegistrationUser  registrationUser){
        Depot d =new Depot();
        d.setDateDepot(new Date());
        d.setMontant(registrationUser.getMontant());
        d.setCompte(registrationUser.getCompte());

        User user=userDetailsService.getUserConnecte();
        d.setUser(user);

        //ajout du montant du depot sur le solde du compte
        Compte cpt= compteRepository.findById(registrationUser.getCompte().getId()).orElseThrow();
        cpt.setSolde(cpt.getSolde()+d.getMontant());
        compteRepository.save(cpt);
        depotRepository.save(d);

        return new ResponseEntity<>("depot reussit", HttpStatus.OK);
    }


    @PostMapping(value = "/compteUser",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> addCompteUser (@RequestBody(required = false) AccountUser  accountUser){
        User user= userRepository.findByUsername(accountUser.getUsername()).orElseThrow();
        user.setUsername(accountUser.getUsername());
        user.setCompte(accountUser.getCompte());
        userRepository.save(user);

        return new ResponseEntity<>("Compte Utilsateur Ajouté Avec Succés", HttpStatus.OK);
    }

    @PostMapping(value = "/findCompte",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public Compte findCompte (@RequestBody(required = false) RegistrationUser  registrationUser) throws Exception {

        Compte c = (Compte) compteRepository.findCompteByNumeroCompte(registrationUser.getNumeroCompte())
                .orElseThrow(()->new Exception ("Ce numero de Compte n'existe pas")

        );


        return c;

    }

    @PostMapping(value = "/envoie",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> envoie (@RequestBody(required = false) Envoie  envoie){


        return new ResponseEntity<>("Compte Utilsateur Ajouté Avec Succés", HttpStatus.OK);

    }
}
