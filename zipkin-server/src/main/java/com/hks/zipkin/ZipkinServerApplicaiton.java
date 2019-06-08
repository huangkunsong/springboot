package com.hks.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplicaiton.class, args);
    }
}
