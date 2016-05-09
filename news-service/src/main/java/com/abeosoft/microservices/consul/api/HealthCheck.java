package com.abeosoft.microservices.consul.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/health")
public class HealthCheck {

    @GET
    public String healthcheck() {
	return "UP";
    }

}
