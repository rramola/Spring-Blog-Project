package com.example.dem1.controller;
import com.example.dem1.model.Content;

import com.example.dem1.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentRepository repository;


    @Autowired
    public ContentController(ContentRepository repository) {
            this.repository = repository;
        }


    // Method to handle GET requests to "/api/content"
    @GetMapping("")
    public List<Content> getAllContent(){
        return repository.findAll();
    }


    // Method to handle GET requests to "/api/content/{id}"
    @GetMapping("/{id}")
    public Content getContentbyId(@PathVariable Integer id) {
        return repository.findById(Long.valueOf(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addContent(@RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateContent(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(Long.valueOf(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        content.setId(Long.valueOf(id));
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteContentById(@PathVariable Integer id) {
        repository.deleteById(Long.valueOf(id));
    }
}
