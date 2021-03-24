package com.geekq.central.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer

public class CentralConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentralConfigurationApplication.class, args);
    }

}
