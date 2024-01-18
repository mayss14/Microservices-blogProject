package projet.blog.Blog_authms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.blog.Blog_authms.entities.Utilisateur;
import projet.blog.Blog_authms.repositories.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
   public List<Utilisateur> FindAll(){
        return utilisateurRepository.findAll();
    }
    public Utilisateur FindById(Long id){
       return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur FindUsername(String username) {
       return utilisateurRepository.findByUsername(username).orElse(null);
    }
}
