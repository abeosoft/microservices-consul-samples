package com.abeosoft.microservices.consul.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abeosoft.microservices.consul.data.HeadlineRepository;
import com.abeosoft.microservices.consul.data.StoryRepository;
import com.abeosoft.microservices.consul.domain.Story;

@RestController
public class NewsApi {

	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private HeadlineRepository headlineRepository;

	@RequestMapping(path = "/stories/today", produces = MediaType.APPLICATION_JSON)
	public List<Story> getDailyStories() {
		return storyRepository.findAll();
	}
}
