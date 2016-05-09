package com.abeosoft.microservices.consul.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abeosoft.microservices.consul.domain.Story;

public interface StoryRepository extends MongoRepository<Story, String>, StoryRepositoryCustom {

    public List<Story> findByTitleLikeOrderByPublishDateDesc(String title);

    public Story findByTitle(String title);

    public List<Story> findBySourceOrderByTitleAsc(String source);

    // public List<Story> findByPublishDateLikeOrderByTitleAsc(Date
    // publishDate);

    public List<Story> findByAuthor(String author);

    public long countByAuthor(String author);
}
