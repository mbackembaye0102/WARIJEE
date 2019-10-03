package com.transfert.wari.controller;


import com.transfert.wari.model.*;
import com.transfert.wari.repository.UserRepository;
import com.transfert.wari.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasAuthority('ROLE_CAISSIER')")
    @GetMapping(value = "/liste")
    public List<User> liste (){

        return userRepository.findAll();
    }


    @Autowired
    PasswordEncoder encoder	;
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/add",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public User add (@RequestBody(required = false) RegistrationUser  registrationUser){
        User u =new User();
        u.setUsername(registrationUser.getUsername());
        u.setName(registrationUser.getName());
        u.setPassword(encoder.encode(registrationUser.getPassword()));
        u.setTelephone(registrationUser.getTelephone());
        u.setStatut("debloquer");
        //ATTRIBUTION DU ROLE
        Set<Role> roles =new HashSet<>();
        Role role =new Role();
        role.setId(registrationUser.getProfil());
        roles.add(role);
        u.setRoles(roles);


        User user=userDetailsService.getUserConnecte();
        user.getPartenaire();
        u.setPartenaire(user.getPartenaire());

        return userRepository.save(u);
    }


    @PostMapping(value = "/statut/{id}",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> findCompte (@RequestBody(required = false) User u){
        User etat= userRepository.findById(u.getId()).orElseThrow();
        if (u.getStatut()=="debloquer"){
            u.setStatut("bloquer");
            userRepository.save(u);
            return new ResponseEntity<>(u.getUsername()+ " a été bloqué", HttpStatus.OK);

        }
        else{
            u.setStatut("debloquer");
            userRepository.save(u);
            return new ResponseEntity<>(u.getUsername()+ " a été débloqué", HttpStatus.OK);
        }




    }



}
