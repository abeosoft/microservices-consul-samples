package com.abeosoft.microservices.consul.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Story {
	
	@Id
	private String id;
	private String source;	
	private String title;
	private String publishDate;
	private String author;
	private String article;
}
