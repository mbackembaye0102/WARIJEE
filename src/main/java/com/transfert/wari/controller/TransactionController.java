package com.transfert.wari.controller;

import com.transfert.wari.model.*;
import com.transfert.wari.repository.*;
import com.transfert.wari.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private TarifRepository tarifRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping(value = "/listeCompte")
    public  List<Compte> listeCompte() {
        return compteRepository.findAll();
    }

    @GetMapping(value = "/listeDepot")
    public  List<Depot> listeDepot() {

        return depotRepository.findAll();
    }

    @GetMapping(value = "/listeTarif")
    public List<Tarif> listeTarif() {

        return tarifRepository.findAll();
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

    //*******************************AJOUTER UN COMPTE A U USER************************************//

    @PostMapping(value = "/compteUser",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> addCompteUser (@RequestBody(required = false) AccountUser  accountUser) throws Exception {
        User user= userRepository.findByUsername(accountUser.getUsername()).orElseThrow(
                ()->new Exception ("Ce username n'existe pas"));

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
        Transaction t=new Transaction();
        //saisie des champs sur postman
        t.setPrenom(envoie.getPrenom());
        t.setNom(envoie.getNom());
        t.setTelephone(envoie.getTelephone());
        t.setTypePiece(envoie.getTypePiece());
        t.setNumeroPiece(envoie.getNumeroPiece());
        t.setPrenomb(envoie.getPrenomb());
        t.setNomb(envoie.getNomb());
        t.setTelephoneb(envoie.getTelephoneb());
        t.setMontant(envoie.getMontant());
        //Generation du code de l'envoie
//        String nb;
//        nb = "WARI"+((int) Math.random()*(99999999-10000000));
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        Date now=new Date();
        String numcompt ="WARI"+ formater.format(now);
        t.setCode(numcompt);
        //Statut de l'envoiet.setEtat("envoyer");
        //Date d'envoie
        t.setDateEnvoie(new Date());
        //recuperation  de l'Id du caissier Envoyeur
        User user=userDetailsService.getUserConnecte();
        t.setGuichetierEnvoie(user);

        //recuper les valeurs du frais
         Tarif tarifPrice = new Tarif();
         List<Tarif> tarifs=  tarifRepository.findAll();

        //recuperer la valeur du montant saisie
        Integer mt =t.getMontant();

        //Verifier si le montant est disponible en solde
        User util=userDetailsService.getUserConnecte();
        Compte ctarif= util.getCompte();

        if(mt>=ctarif.getSolde()){
            return new ResponseEntity<>("Votre Solde "+ctarif.getSolde()+" ne vous permet pas d'effectuer cette opération", HttpStatus.OK);
        }
        //Compte sur mle quel on a effectué l'opération
        t.setCompte(ctarif);
        // trouver les frais qui correspond au montant
        tarifPrice.getBorneInferieure();
        tarifPrice.getGetBorneSuperieure();
        tarifPrice.getValeur();
       // for (Tarif tarif: tarifs){
        for (int i=0; i<tarifs.size(); i++){

            if(mt >= tarifPrice.getBorneInferieure() && mt <=tarifPrice.getGetBorneSuperieure()){
                    tarifPrice.getValeur();
            }
        }

        //Frais de l'envoie
        t.setFrais(tarifPrice.getValeur());

        // repartition des commissions
        int wari= (tarifPrice.getValeur()*40)/100;
        int envoye= (tarifPrice.getValeur()*20)/100;
        int retrait= (tarifPrice.getValeur()*10)/100;
        int etat= (tarifPrice.getValeur()*30)/100;

        // dimunition du monatnt envoyé au niveau du solde et ajout de la commission pour l'envoie
            ctarif.setSolde(ctarif.getSolde()-t.getMontant()+ envoye);
            compteRepository.save(ctarif);

            t.setCommissionEnvoie(envoye);
            t.setCommissionRetrait(retrait);
            t.setCommissionEtat(etat);
            t.setCommissionWari(wari);

        int total=t.getMontant()+tarifPrice.getValeur();
        t.setTotal(total);
        transactionRepository.save(t);

        return new ResponseEntity<>("ENVOIE EFFECTUÉ AVEC SUCCÉS", HttpStatus.OK);
    }

    @PostMapping(value = "/findCode",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public Transaction findUsername (@RequestBody(required = false) Envoie  envoie) throws Exception {

        Transaction t = (Transaction) transactionRepository.findTransactionByCode(envoie.getCode())
                .orElseThrow(()->new Exception ("Ce code n'existe pas")

                );
        return t;

    }

}
