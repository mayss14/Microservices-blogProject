package projet.blog.Blog_authms.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import projet.blog.Blog_authms.entities.Utilisateur;
import projet.blog.Blog_authms.models.AuthenticationRequest;
import projet.blog.Blog_authms.models.AuthenticationResponse;
import projet.blog.Blog_authms.models.RegisterRequest;
import projet.blog.Blog_authms.services.AuthenticationService;
import projet.blog.Blog_authms.services.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/users/auth")
@RequiredArgsConstructor
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){
         return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }
    @GetMapping
    public List<Utilisateur> getAll(){
      return utilisateurService.FindAll();
    }
    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id){
        return utilisateurService.FindById(id);
    }
    @GetMapping("/user/{username}")
    public Utilisateur getByUsername(@PathVariable  String username){
        return utilisateurService.FindUsername(username);
    }
}
