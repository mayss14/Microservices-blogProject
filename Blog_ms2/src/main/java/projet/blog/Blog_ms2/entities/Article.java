package projet.blog.Blog_ms2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article  {

    private Long id;
    private String contenu;
    private String titre;
    private int claps;
    private String urlphoto;
    private Categorie categorie;
    Utilisateur auteur;
}
