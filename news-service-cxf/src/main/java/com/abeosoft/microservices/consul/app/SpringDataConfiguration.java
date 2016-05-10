package com.abeosoft.microservices.consul.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.abeosoft.microservices.consul.data.StoryDocumentConverter;

@Configuration
@EnableMongoRepositories(basePackages = "com.abeosoft.microservices.consul.data")
public class SpringDataConfiguration {

    @Bean
    public CustomConversions customConversions() {
	List<Converter<?, ?>> converters = new ArrayList<>();
	converters.add(new StoryDocumentConverter());
	return new CustomConversions(converters);
    }
}
