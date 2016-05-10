package com.abeosoft.microservices.consul.util;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

@Component
@Provider
public class ObjectMapperUsingJavaTimeModule implements ContextResolver<ObjectMapper> {

    @Override
    public ObjectMapper getContext(Class<?> type) {
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	mapper.setSerializationInclusion(Include.NON_NULL);
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	mapper.registerModule(new JavaTimeModule());

	mapper.setAnnotationIntrospector(AnnotationIntrospector.pair(new JacksonAnnotationIntrospector(),
		new JaxbAnnotationIntrospector(mapper.getTypeFactory())));
	return mapper;
    }

}
