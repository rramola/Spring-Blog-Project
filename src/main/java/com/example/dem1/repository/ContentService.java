package com.example.dem1.repository;

import com.example.dem1.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    private final ContentRepository repository;

    @Autowired
    public ContentService(ContentRepository repository) {
        this.repository = repository;
    }

    public List<Content> getContent(){
        return repository.findAll();
    }
    public Content getContentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id " + id));
    }

    public Content saveContent(Content content) {
        // Additional logic can be added here if needed
        return repository.save(content);
    }

    public void deleteContentById(Long id) {
        repository.deleteById(id);
    }
}
