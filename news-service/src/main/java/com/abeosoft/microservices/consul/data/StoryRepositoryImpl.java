package com.abeosoft.microservices.consul.data;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.abeosoft.microservices.consul.domain.Story;

public class StoryRepositoryImpl implements StoryRepositoryCustom {

    @Inject
    private MongoOperations mongoOperations;

    @Override
    public List<Story> getStoriesByAuthor(String author) {
	return mongoOperations.find(new Query(where("author").is(author)), Story.class);
    }

    @Override
    public long countStoriesByAuthor(String author) {
	return mongoOperations.count(new Query(where("author").is(author)), Story.class);
    }
}
