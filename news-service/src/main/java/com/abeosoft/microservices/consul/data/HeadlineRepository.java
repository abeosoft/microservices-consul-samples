package com.abeosoft.microservices.consul.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abeosoft.microservices.consul.domain.Headline;

public interface HeadlineRepository extends MongoRepository<Headline, String> {
	public Headline findByTitle(String title);

	public List<Headline> findBySource(String source);

	public List<Headline> findByPublishDate(Date publishDate);

	public List<Headline> findByAuthor(String author);

}
