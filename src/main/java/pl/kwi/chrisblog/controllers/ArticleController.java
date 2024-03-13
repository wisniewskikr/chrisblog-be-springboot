package pl.kwi.chrisblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.kwi.chrisblog.db.entities.ArticleEntity;
import pl.kwi.chrisblog.dtos.ArticleRequest;
import pl.kwi.chrisblog.dtos.ArticleResponse;
import pl.kwi.chrisblog.services.ArticleService;

@RestController
@CrossOrigin("${fe.url}")
public class ArticleController {


    private ArticleService articleService;

    
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("api/v1/article")
    public ArticleResponse findArticles(@RequestBody ArticleRequest request) {
        return articleService.findArticles(request);
    }

    @GetMapping("api/v1/article/{id}")
    public ArticleEntity findArticleById(@PathVariable Long id) {
        return articleService.findArticleById(id);
    }
    
}
