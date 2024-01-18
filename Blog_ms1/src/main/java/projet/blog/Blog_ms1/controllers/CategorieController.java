package projet.blog.Blog_ms1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projet.blog.Blog_ms1.entities.Article;
import projet.blog.Blog_ms1.entities.Categorie;
import projet.blog.Blog_ms1.services.ArticleService;
import projet.blog.Blog_ms1.services.CategorieService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    @GetMapping
    List<Categorie> ShowAll(){
        return categorieService.FindAll();
    }
    @PostMapping
    void Add(@RequestBody Categorie categorie){
        categorieService.AddCategorie(categorie);
    }
    @DeleteMapping("/{id}")
    void Delete(@PathVariable Long id){
        categorieService.DeleteCategorie(id);
    }
    @GetMapping("/{id}")
    Categorie Find(@PathVariable Long id) throws Exception {
        return categorieService.FindById(id);
    }
    @PutMapping
    Categorie Update(@RequestBody Categorie categorie){
        return categorieService.UpdateCategorie(categorie);
    }
}
