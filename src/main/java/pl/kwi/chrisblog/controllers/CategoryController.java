package pl.kwi.chrisblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.kwi.chrisblog.dtos.CategoryResponse;
import pl.kwi.chrisblog.services.ArticleService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CategoryController {


    private ArticleService articleService;

    
    @Autowired
    public CategoryController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("api/v1/category")
    public CategoryResponse findCategories() {
        return null;
    }
    
}
