package com.transfert.wari.controller;


import com.transfert.wari.model.*;
import com.transfert.wari.repository.CompteRepository;
import com.transfert.wari.repository.PartenaireRepository;
import com.transfert.wari.repository.UserRepository;
import com.transfert.wari.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/partenaire")
public class PartenaireController {


    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PartenaireRepository partenaireRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private UserRepository userRepository;


//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @GetMapping(value = "/liste")
//    public List<Partenaire> liste() {
//
//        return partenaireRepository.findAll();
//    }


    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/add",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public Partenaire add (@RequestBody(required = false) Partenaire p){
        p.setStatut("debloquer");
        return partenaireRepository.save(p);
    }

    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/addCompte",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public Compte add (@RequestBody(required = false) Compte c){

//        String nb;
//        nb = "MA"+(10000+(int) Math.random()*(99999-10000));
//        c.setNumeroCompte(nb);

        SimpleDateFormat formater = null;

        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        Date now=new Date();
        String numcompt = formater.format(now);

        c.setNumeroCompte(numcompt);
        c.setSolde(75000);


        return compteRepository.save(c);
    }

    @Autowired
    PasswordEncoder encoder;

    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/addPartener", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Partenaire add(@RequestBody(required = false) RegistrationPartenaire registrationPartenaire) {

        //AJOUT PARTENAIRE
        Partenaire p = new Partenaire();
        p.setEntreprise(registrationPartenaire.getEntreprise());
        p.setNinea(registrationPartenaire.getNinea());
        p.setAdresse(registrationPartenaire.getAdresse());
        p.setStatut("debloquer");
        partenaireRepository.save(p);

        //AJOUT COMPTE
        Compte c = new Compte();
       // String nb;
       // nb = "MA"+(10000+(int) Math.random()*(99999-10000));
        SimpleDateFormat formater = null;

        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        Date now=new Date();
        String numcompt = formater.format(now);

        c.setNumeroCompte(numcompt);
        //c.setNumeroCompte(nb);
        c.setPartenaire(p);
        c.setSolde(75000);
        compteRepository.save(c);

        //AJOUT UTILISATEUR
        User u = new User();
        u.setUsername(registrationPartenaire.getUsername());
        u.setName(registrationPartenaire.getName());
        u.setPassword(encoder.encode(registrationPartenaire.getPassword()));
        u.setTelephone(registrationPartenaire.getTelephone());
        u.setStatut("debloquer");
        Set<Role> roles =new HashSet<>();
        Role role =new Role();
        role.setId(registrationPartenaire.getProfil());
        roles.add(role);
        u.setRoles(roles);
        u.setPartenaire(p);
        u.setCompte(c);
        userRepository.save(u);

       return partenaireRepository.save(p);
    }


}
