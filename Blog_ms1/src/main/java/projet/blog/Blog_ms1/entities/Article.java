package projet.blog.Blog_ms1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private String titre;
    private int claps;
    //private String urlphoto;
    @ManyToOne
    private Categorie categorie;
    Long auteur;
}
