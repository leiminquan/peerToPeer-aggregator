package com.lxit.p2p;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LMQClient {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(LMQClient.class).web(true).run(args);
	}
}
