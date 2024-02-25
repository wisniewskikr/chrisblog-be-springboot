package pl.kwi.chrisblog.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.kwi.chrisblog.dtos.ArticleRequest;

@RestController
@CrossOrigin("http://localhost:4200")
public class ArticleController {

    @PostMapping("api/v1/article")
    public String findArticlesByHomeCategory(@RequestBody ArticleRequest request) {

        System.out.println("request: " + request.toString());

        return "Ok";

    }
    
}
