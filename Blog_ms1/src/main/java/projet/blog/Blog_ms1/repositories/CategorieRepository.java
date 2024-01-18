package projet.blog.Blog_ms1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.blog.Blog_ms1.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
