package com.stackroute.trackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//annotation added for swagger
@EnableSwagger2
public class TrackServiceApplication {


	public static void main(String[] args) {

		SpringApplication.run(TrackServiceApplication.class, args);
	}

}
