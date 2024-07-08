package com.example.dem1.repository;

import com.example.dem1.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    private  ContentRepository repository;

    public List<Content> getContent(){
        return repository.findAll();
    }
    public Content getContentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id " + id));
    }

    public Optional<Content> getContentByTitle(String title) {

        return Optional.ofNullable(repository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Content not found with title" + title)));
    }

    public Content saveContent(Content content) {
        return repository.save(content);
    }

    public Content updateContent(Content content, Integer id){
        if(!repository.existsById(Long.valueOf(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        content.setId(Long.valueOf(id));
        repository.save(content);
        return content;
    }

    public void deleteContentById(Long id) {
        repository.deleteById(id);
    }

}
