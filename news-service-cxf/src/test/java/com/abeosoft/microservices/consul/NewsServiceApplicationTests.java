package com.abeosoft.microservices.consul;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.abeosoft.microservices.consul.app.NewsServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NewsServiceApplication.class)
@WebAppConfiguration
@Ignore
public class NewsServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
