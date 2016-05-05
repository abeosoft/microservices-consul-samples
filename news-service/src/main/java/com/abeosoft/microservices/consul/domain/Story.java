package com.abeosoft.microservices.consul.domain;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Story {

	@Id
	private String id;
	private String source;
	private String title;
	private Date publishDate;
	private String author;
	private String article;

	public Story(String title, Date publishDate, String author, String article) {
		this.source = "WEB";
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.article = article;
	}
}
