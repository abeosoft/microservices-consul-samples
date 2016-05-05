package com.abeosoft.microservices.consul.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abeosoft.microservices.consul.domain.Story;

public interface StoryRepository extends MongoRepository<Story, String> {
    public Story findByTitle(String title);

    public List<Story> findBySource(String source);

    public List<Story> findByPublishDate(Date publishDate);

    public List<Story> findByAuthor(String author);
}
