package com.hks.feign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FeignApplication {

	@Bean
	Logger.Level feignLevel() {
		return Logger.Level.FULL;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
}
