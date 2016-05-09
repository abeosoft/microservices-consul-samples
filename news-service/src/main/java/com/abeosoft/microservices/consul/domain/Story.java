package com.abeosoft.microservices.consul.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Story {

    @Id
    private String id;

    private String source;

    private String title;

    @JsonFormat(shape = Shape.STRING, pattern = "MM-dd-YYYY")
    private LocalDateTime publishDate;

    private String author;

    private String article;

    public Story(String title, LocalDateTime publishDate, String author, String article) {
	this.source = "WEB";
	this.title = title;
	this.publishDate = publishDate;
	this.author = author;
	this.article = article;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getSource() {
	return source;
    }

    public void setSource(String source) {
	this.source = source;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public LocalDateTime getPublishDate() {
	return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
	this.publishDate = publishDate;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public String getArticle() {
	return article;
    }

    public void setArticle(String article) {
	this.article = article;
    }

    public Date getPublishDateLegacy() {
	return Date.from(publishDate.atZone(ZoneId.systemDefault()).toInstant());
    }
}
