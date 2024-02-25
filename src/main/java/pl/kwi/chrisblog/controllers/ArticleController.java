package pl.kwi.chrisblog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @GetMapping
    public List<String> findArticlesByCategory() {
        List<String> result = new ArrayList<>();
        result.add("Test");
        return result;
    }
    
}
