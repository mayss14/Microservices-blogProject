package projet.blog.Blog_ms2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.blog.Blog_ms2.entities.Article;
import projet.blog.Blog_ms2.entities.Utilisateur;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentaireResponse {

        private Long id;
        private String contenu;
        private Article article;
        private Utilisateur auteur;

}
