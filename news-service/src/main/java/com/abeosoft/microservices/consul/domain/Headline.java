package com.abeosoft.microservices.consul.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Headline {
	
	@Id
	private String id;
	private String source;	
	private String title;
	private String publishDate;
	private String author;
	private String excerpt;
}
