package com.example.dem1.controller;
import com.example.dem1.model.Content;
import java.util.Optional;

import com.example.dem1.repository.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("")
    public List<Content> getAllContent(){
        return contentService.getContent();
    }

    @GetMapping("/id/{id}")
    public Content getContentById(@PathVariable Integer id) {
        return contentService.getContentById(Long.valueOf(id));
    }

    @GetMapping("/title/{title}")
    public Optional<Content> getContentByTitle(@PathVariable String title) {
        return contentService.getContentByTitle(title);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Content addContent(@RequestBody Content content) {
        return contentService.saveContent(content);
    }


    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Content updateContent(@RequestBody Content content, @PathVariable Integer id){
        return contentService.updateContent(content, id);
    }


    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContentById(@PathVariable Integer id) {
        contentService.deleteContentById(Long.valueOf(id));
    }
}
