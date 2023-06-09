package com.vedika.zuul.ZuulMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/*
 http://localhost:8989/mentorportal/skillTechService/skillstech/hello
 */
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulMicroserviceApplication.class, args);
	}

}

