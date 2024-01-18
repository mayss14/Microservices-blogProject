package projet.blog.Blog_ms1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.blog.Blog_ms1.entities.Article;
import projet.blog.Blog_ms1.entities.Utilisateur;
import projet.blog.Blog_ms1.models.ArticleResponse;
import projet.blog.Blog_ms1.services.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @GetMapping
    List<ArticleResponse> ShowAll(){
        return articleService.findAll();
    }
    @PostMapping
    void Add(@RequestBody Article article){
        articleService.addArticle(article);
    }
    @DeleteMapping("/{id}")
    void Delete(@PathVariable Long id){
      articleService.deleteArticle(id);
    }
    @GetMapping("/{id}")
    ArticleResponse Find(@PathVariable Long id) throws Exception {
        return articleService.findById(id);
    }
    @PutMapping
     ArticleResponse Update(@RequestBody Article article){
        return articleService.updateArticle(article);
    }
    @GetMapping("auteur/{id}")
    Utilisateur getAuteur(@PathVariable Long id){
        return articleService.getArticleAuteur(id);
    }

    @GetMapping("/written/{id}")
    List<ArticleResponse> getArticlesByAuteur(@PathVariable Long id){
        return articleService.findArticlesByAuteur(id);
    }

}
