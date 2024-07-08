package com.example.dem1.repository;


import com.example.dem1.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    Optional<Content> findByTitle(String title);
}