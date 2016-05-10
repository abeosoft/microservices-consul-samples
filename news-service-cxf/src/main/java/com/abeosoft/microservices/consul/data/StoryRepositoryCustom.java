package com.abeosoft.microservices.consul.data;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.abeosoft.microservices.consul.domain.Story;

@NoRepositoryBean
public interface StoryRepositoryCustom {

    List<Story> getDailyStories();

}
