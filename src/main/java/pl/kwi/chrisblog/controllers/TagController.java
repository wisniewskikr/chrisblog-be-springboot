package pl.kwi.chrisblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.kwi.chrisblog.dtos.TagRequest;
import pl.kwi.chrisblog.dtos.TagResponse;
import pl.kwi.chrisblog.services.TagService;

@RestController
@CrossOrigin("${fe.url}")
public class TagController {


    private TagService tagService;

    
    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }


    @PostMapping("api/v1/tag")
    public TagResponse findTags(@RequestBody TagRequest tagRequest) {
        return tagService.findTags(tagRequest);
    }
    
    
}
