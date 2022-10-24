package com.config.srv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSrvApplication.class, args);
	}

}
