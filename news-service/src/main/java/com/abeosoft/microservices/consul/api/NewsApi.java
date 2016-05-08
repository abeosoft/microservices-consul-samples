package com.abeosoft.microservices.consul.api;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abeosoft.microservices.consul.data.StoryRepository;
import com.abeosoft.microservices.consul.domain.Story;

@RestController
public class NewsApi {

    private Logger logger = LoggerFactory.getLogger(NewsApi.class);

    @Inject
    private StoryRepository storyRepository;

    @RequestMapping(value = "/stories", produces = { "application/json" })
    public List<Story> getStories() {
	List<Story> storiesByAuthor = storyRepository.findAll(new Sort(Sort.Direction.ASC, "author"));
	logger.debug("Repository returned count: " + storiesByAuthor.size());
	return storiesByAuthor;
    }

    @RequestMapping(value = "/stories/contents/{title}", produces = { "application/json" })
    public List<Story> getStoriesByTitle(@PathVariable String title) {
	List<Story> storiesByAuthor = storyRepository.findByTitle(title);
	logger.debug("Repository returned count: " + storiesByAuthor.size());
	return storiesByAuthor;
    }

    @RequestMapping(value = "/stories/terms/{terms}", produces = { "application/json" })
    public List<Story> getStoriesByTerms(@PathVariable String terms) {
	List<Story> storiesByAuthor = storyRepository.findByTitleLikeOrderByPublishDateDesc(terms);
	logger.debug("Repository returned count: " + storiesByAuthor.size());
	return storiesByAuthor;
    }

    @RequestMapping(value = "/stories/authors/{author}", produces = { "application/json" })
    public List<Story> getStoriesByAuthor(@PathVariable String author) {
	List<Story> storiesByAuthor = storyRepository.findByAuthor(author);
	logger.debug("Repository returned count: " + storiesByAuthor.size());
	return storiesByAuthor;
    }

    @RequestMapping(value = "/stories/sources/{source}", produces = { "application/json" })
    public List<Story> getStoriesBySource(@PathVariable String source) {
	List<Story> storiesBySource = storyRepository.findBySource(source);
	logger.debug("Repository returned count: " + storiesBySource.size());
	return storiesBySource;
    }

    @RequestMapping(value = "/stories/{publishDate}", produces = { "application/json" })
    public List<Story> getStoriesByPublishDate(@PathVariable Date publishDate) {
	List<Story> storiesByPublishDate = storyRepository.findByPublishDate(publishDate);
	logger.debug("Repository returned count: " + storiesByPublishDate.size());
	return storiesByPublishDate;
    }

    @RequestMapping(value = "/stories/count/authors/{author}", produces = { "application/json" })
    public String countStoriesByAuthor(@PathVariable String author) {
	long count = storyRepository.countStoriesByAuthor(author);
	JSONObject json = new JSONObject();
	json.put("author", author);
	json.put("story_count", count);
	return json.toString();
    }

    // @Autowired
    // private StoryRepository storyRepository;
    // @RequestMapping(value = "/stories/today/{page}", produces = {
    // "application/json" })
    // public Collection<Story> getDailyStories(@PathVariable int page) {
    // return storyRepository.findAll(new PageRequest(page,
    // PAGE_SIZE)).getContent();
    // }
}
