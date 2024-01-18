package projet.blog.Blog_ms1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projet.blog.Blog_ms1.entities.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query("SELECT a FROM Article a WHERE a.auteur = :author")
    List<Article> findByAuthor(Long  author);
}
