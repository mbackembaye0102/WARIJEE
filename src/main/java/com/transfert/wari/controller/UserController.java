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


    @PutMapping(value = "/statut/{id}",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> blockUser (@PathVariable("id")long id) throws Exception {
        User etat= userRepository.findById(id).orElseThrow(
                ()->new Exception ("Ce user n'existe pas")
        );

        if(etat.getUsername().equals("kabirou")){
            return new ResponseEntity<>(etat.getUsername()+ " Ne peut pas être bloqué car c'est le super admin", HttpStatus.OK);
        }
        if (etat.getStatut().equals("debloquer")){
            etat.setStatut("bloquer");
            userRepository.save(etat);
            return new ResponseEntity<>(etat.getUsername()+ " a été bloqué", HttpStatus.OK);
        }
        else{
            etat.setStatut("debloquer");
            userRepository.save(etat);
            return new ResponseEntity<>(etat.getUsername()+ " a été débloqué", HttpStatus.OK);
        }
    }

    @PostMapping(value = "/findUsername",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public User findUsername (@RequestBody(required = false) RegistrationUser  registrationUser) throws Exception {

        User u = (User) userRepository.findUserByUsername(registrationUser.getUsername())
                .orElseThrow(()->new Exception ("Ce username n'existe pas")

                );
        return u;

    }


}
