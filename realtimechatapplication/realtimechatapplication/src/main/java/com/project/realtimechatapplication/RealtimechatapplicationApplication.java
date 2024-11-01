package com.project.realtimechatapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RealtimechatapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimechatapplicationApplication.class, args);
	}

}
