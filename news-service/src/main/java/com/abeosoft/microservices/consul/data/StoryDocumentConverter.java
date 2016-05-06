package com.abeosoft.microservices.consul.data;

import java.util.Calendar;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.abeosoft.microservices.consul.domain.Story;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Component
public class StoryDocumentConverter implements Converter<Story, DBObject> {

    public DBObject convert(Story source) {
	DBObject dbo = new BasicDBObject();
	dbo.put("_id", source.getId());
	dbo.put("title", source.getTitle());
	dbo.put("author", source.getAuthor());

	dbo.put("publishDate", DateUtils.truncate(source.getPublishDate(), Calendar.HOUR));
	dbo.put("source", source.getSource());
	dbo.removeField("_class");
	return dbo;
    }

}