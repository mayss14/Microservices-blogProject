package projet.blog.Blog_ms2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projet.blog.Blog_ms2.entities.Commentaire;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
    @Query("SELECT a FROM Commentaire a WHERE a.idArticle = :article")
    List<Commentaire> findCommentsByIdArticle(Long  article);
}
