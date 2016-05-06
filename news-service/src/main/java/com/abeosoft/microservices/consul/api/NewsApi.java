package com.abeosoft.microservices.consul.api;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abeosoft.microservices.consul.data.StoryDao;
import com.abeosoft.microservices.consul.domain.Story;

@RestController
public class NewsApi {

    private Logger logger = LoggerFactory.getLogger(NewsApi.class);

    @Autowired
    private StoryDao storyDao;

    @RequestMapping(value = "/stories/authors/{author}", produces = { "application/json" })
    public List<Story> getStoriesByAuthor(@PathVariable String author) {
	List<Story> storiesByAuthor = storyDao.getStoriesByAuthor(author);
	logger.debug("Repository returned count: " + storiesByAuthor.size());
	return storiesByAuthor;

    }

    @RequestMapping(value = "/stories/count/authors/{author}", produces = { "application/json" })
    public String countStoriesByAuthor(@PathVariable String author) {
	long count = storyDao.countStoriesByAuthor(author);
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
