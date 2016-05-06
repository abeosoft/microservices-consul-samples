package com.abeosoft.microservices.consul.data;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.abeosoft.microservices.consul.domain.Story;

@Repository
public class StoryDao {

    @Autowired
    private StoryDocumentConverter storyDocumentConverter;

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
	this.mongoTemplate = mongoTemplate;
    }
    public List<Story> getStoriesByAuthor(String author) {
	return mongoTemplate.find(new Query(where("author").is(author)), Story.class);
    }

    public long countStoriesByAuthor(String author) {
	return mongoTemplate.count(new Query(where("author").is(author)), Story.class);
    }
}
