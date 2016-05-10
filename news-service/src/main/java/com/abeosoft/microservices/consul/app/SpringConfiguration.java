package com.abeosoft.microservices.consul.app;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.abeosoft.microservices.consul.api.AdminApi;
import com.abeosoft.microservices.consul.api.HealthCheck;
import com.abeosoft.microservices.consul.api.NewsApi;
import com.abeosoft.microservices.consul.data.StoryDocumentConverter;
import com.abeosoft.microservices.consul.util.ObjectMapperUsingJavaTimeModule;

@Configuration
@ComponentScan
@EnableMongoRepositories(basePackages = "com.abeosoft.microservices.consul.data")
public class SpringConfiguration {

    @Bean
    public CustomConversions customConversions() {
	List<Converter<?, ?>> converters = new ArrayList<>();
	converters.add(new StoryDocumentConverter());
	return new CustomConversions(converters);
    }

    @Bean
    public ResourceConfig jerseyConfiguration() {
	ResourceConfig resourceConfig = new ResourceConfig();

	resourceConfig.property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
	resourceConfig.property(ServerProperties.TRACING, "OFF");
	resourceConfig.property(ServerProperties.WADL_FEATURE_DISABLE, true);

	resourceConfig.register(JacksonFeature.class);
	resourceConfig.register(new ObjectMapperUsingJavaTimeModule());
	resourceConfig.register(LoggingFilter.class);
	resourceConfig.register(DeflateEncoder.class);
	resourceConfig.register(GZipEncoder.class);

	resourceConfig.register(AdminApi.class);
	resourceConfig.register(HealthCheck.class);
	resourceConfig.register(NewsApi.class);
	return resourceConfig;
    }
}
