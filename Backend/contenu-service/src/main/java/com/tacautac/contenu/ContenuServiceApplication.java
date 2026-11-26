package com.tacautac.contenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ContenuServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContenuServiceApplication.class, args);
    }

}
