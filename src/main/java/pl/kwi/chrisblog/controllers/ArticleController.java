package pl.kwi.chrisblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.kwi.chrisblog.dtos.ArticleRequest;
import pl.kwi.chrisblog.dtos.ArticleResponse;
import pl.kwi.chrisblog.services.ArticleService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ArticleController {


    private ArticleService articleService;

    
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("api/v1/article")
    public ArticleResponse findArticlesByHomeCategory(@RequestBody ArticleRequest request) {
        return articleService.findArticlesByHomeCategory(request);
    }
    
}
