package com.transfert.wari.controller;


import com.transfert.wari.model.*;
import com.transfert.wari.repository.CompteRepository;
import com.transfert.wari.repository.PartenaireRepository;
import com.transfert.wari.repository.UserRepository;
import com.transfert.wari.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    @GetMapping(value = "/listePartenaire")
    public  List<Partenaire> liste() {
        return partenaireRepository.findAll();
    }


    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/add",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public Partenaire add (@RequestBody(required = false) Partenaire p){
        p.setStatut("debloquer");
        return partenaireRepository.save(p);
    }

    //@PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/addCompte",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public Compte add (@RequestBody(required = false) Compte c){
        String nb;
        nb = "COMPTE"+(10000000+(int) Math.random()*(99999999-10000000));
        c.setNumeroCompte(nb);
        c.setSolde(75000);
//        SimpleDateFormat formater = null;
//        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
//        Date now=new Date();
//        String numcompt = formater.format(now);
//        c.setNumeroCompte(numcompt);

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
        //1er Methode
       // String nb;
       // nb = "MA"+(10000+(int) Math.random()*(99999-10000));
        //c.setNumeroCompte(nb);


        //2e Methode Génération du numero de compte
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        Date now=new Date();
        String numcompt = formater.format(now);
        c.setNumeroCompte(numcompt);
        //l'id du partenaire
        c.setPartenaire(p);
        //le solde initial
        c.setSolde(75000);
        compteRepository.save(c);

        //AJOUT UTILISATEUR
        User u = new User();
        u.setUsername(registrationPartenaire.getUsername());
        u.setName(registrationPartenaire.getName());
        u.setPassword(encoder.encode(registrationPartenaire.getPassword()));
        u.setTelephone(registrationPartenaire.getTelephone());
        u.setStatut("debloquer");
        //Attribuer un role
        Set<Role> roles =new HashSet<>();
        Role role =new Role();
        role.setId((long)4);
        roles.add(role);
        u.setRoles(roles);
        //id partenaire
        u.setPartenaire(p);
        //id compte
        u.setCompte(c);
        userRepository.save(u);

       return partenaireRepository.save(p);
    }



    @PutMapping(value = "/statut/{id}",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> blockPartener (@PathVariable("id")int id) throws Exception {
        Partenaire etat= partenaireRepository.findById((int) id).orElseThrow(
                ()->new Exception ("Ce Partenaire n'existe pas")
        );


        if (etat.getStatut().equals("debloquer")){
            etat.setStatut("bloquer");
            partenaireRepository.save(etat);
            return new ResponseEntity<>(etat.getEntreprise()+ " a été bloqué", HttpStatus.OK);
        }
        else{
            etat.setStatut("debloquer");
            partenaireRepository.save(etat);
            return new ResponseEntity<>(etat.getEntreprise()+ " a été débloqué", HttpStatus.OK);
        }
    }

}
