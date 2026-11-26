package com.tacautac.progression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProgressionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgressionServiceApplication.class, args);
    }

}
