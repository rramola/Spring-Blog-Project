package com.example.dem1.config;
import com.example.dem1.model.Content;
import com.example.dem1.model.Status;
import com.example.dem1.model.Type;
import com.example.dem1.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

@Configuration
public class ContentInitializer {

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository) {
        return args -> {

            Content content1 = new Content(
                    "Title 1",
                    "Description 1",
                    Status.IN_PROGRESS,
                    Type.VIDEO,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "http://example.com/1"
            );

            Content content2 = new Content(
                    "Title 2",
                    "Description 2",
                    Status.IN_PROGRESS,
                    Type.VIDEO,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "http://example.com/2"
            );

            // Save to repository
            repository.save(content1);
            repository.save(content2);
        };
    }
}

