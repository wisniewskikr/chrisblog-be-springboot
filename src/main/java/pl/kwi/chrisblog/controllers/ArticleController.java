package pl.kwi.chrisblog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.kwi.chrisblog.dtos.ArticleRequest;

@RestController
@CrossOrigin("http://localhost:4200")
public class ArticleController {

    @GetMapping("api/v1/article")
    public List<String> findArticlesByHomeCategory(@RequestBody ArticleRequest request) {
        List<String> result = new ArrayList<>();
        result.add("Test");
        return result;
    }
    
}
