package com.hks.actuatoradmin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAdminServer
@SpringBootApplication
public class ActuatorAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorAdminApplication.class, args);
	}
}
