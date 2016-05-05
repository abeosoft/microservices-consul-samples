package com.abeosoft.microservices.consul.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abeosoft.microservices.consul.data.HeadlineRepository;
import com.abeosoft.microservices.consul.data.StoryRepository;
import com.abeosoft.microservices.consul.domain.Story;

@RestController
public class NewsApi {

    private static final int PAGE_SIZE = 3;

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private HeadlineRepository headlineRepository;

    @RequestMapping(value = "/stories/today/{page}", produces = { "application/json" })
    public Collection<Story> getDailyStories(@PathVariable int page) {
	return storyRepository.findAll(new PageRequest(page, PAGE_SIZE)).getContent();
    }
}
