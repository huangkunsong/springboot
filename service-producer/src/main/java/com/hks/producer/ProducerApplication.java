package com.hks.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringCloudApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.hks.producer.dao")
@ServletComponentScan
public class ProducerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProducerApplication.class, args);
	}
}
